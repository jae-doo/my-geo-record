package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.dto.*;
import site.jaedoo.mygeorecord.domain.entity.DataType;
import site.jaedoo.mygeorecord.domain.repository.DataGroupRepository;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.*;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupFieldMapper;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@Repository("dataGroupRepository")
@RequiredArgsConstructor
public class MyBatisDataGroupRepository implements DataGroupRepository {
    private final DataGroupMapper dataGroupMapper;
    private final DataGroupFieldMapper fieldMapper;

    @Override
    public List<DataGroupInfo> findAllUserDataGroupInfo(Long userId) {
        return dataGroupMapper.findAllDataGroupInfoByUserId(userId)
                .stream().collect(new DataGroupInfoCollector());
    }

    @Override
    public List<DataGroupInfo> findAllGeoTableDataGroupInfo(Long userId, Long geoTableId) {
        return dataGroupMapper.findAllDataGroupInfoByGeoTableId(geoTableId)
                .stream().collect(new DataGroupInfoCollector());
    }

    @Override
    public int insertDataGroup(DataGroupCreation info) {
        DataGroupInsert dataGroupInsert = new DataGroupInsert(info);
        int dataGroupModified = dataGroupMapper.insertDataGroup(dataGroupInsert);

        Long dataGroupId = dataGroupInsert.getDataGroupId();

        List<DataGroupFieldInsert> fieldInsertList = info.columnList().stream()
                .map(c -> new DataGroupFieldInsert(dataGroupId, c)).toList();

        int fieldModified = fieldMapper.batchInsertDataGroupField(dataGroupId, fieldInsertList);

        return dataGroupModified + fieldModified;
    }

    @Override
    public int updateDataGroup(DataGroupEdit info) {
        return dataGroupMapper.updateDataGroup(new DataGroupUpdate(info));
    }

    @Override
    public int deleteDataGroup(Long dataGroupId) {
        return dataGroupMapper.deleteDataGroup(dataGroupId);
    }

    @Override
    public int insertDataGroupField(DataGroupFieldCreation info) {
        return fieldMapper.insertDataGroupField(new DataGroupFieldInsert(info));
    }

    @Override
    public int updateDataGroupField(DataGroupFieldEdit info) {
        return fieldMapper.updateDataGroupField(new DataGroupFieldUpdate(info));
    }

    @Override
    public int deleteDataGroupField(Long dataGroupFieldId) {
        return fieldMapper.deleteDataGroupField(dataGroupFieldId);
    }

    private static class DataGroupInfoCollector implements Collector<DataGroupFieldRecord, Map<Long, DataGroupInfoCollector.DataGroupStore>, List<DataGroupInfo>> {
        public Supplier<Map<Long, DataGroupStore>> supplier() {
            return ConcurrentHashMap::new;
        }

        public BiConsumer<Map<Long, DataGroupStore>, DataGroupFieldRecord> accumulator() {
            return (map, dataGroupFieldInfo) ->
                map.computeIfAbsent(dataGroupFieldInfo.getDataGroupId(), (key) -> new DataGroupStore(dataGroupFieldInfo))
                        .addColumn(dataGroupFieldInfo);
        }

        @Override
        public BinaryOperator<Map<Long, DataGroupStore>> combiner() {
            return (a, b) -> {
                a.putAll(b);
                return a;
            };
        }

        public Function<Map<Long, DataGroupStore>, List<DataGroupInfo>> finisher() {
            return map -> map.values().stream()
                    .map(DataGroupStore::toDataGroupInfo)
                    .toList();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of();
        }

        @Data
        public static class DataGroupStore {
            Long mapId;
            Long dataGroupId;
            String groupName;
            List<DataGroupFieldInfo> columnList;

            public DataGroupStore(DataGroupFieldRecord dgif) {
                this.mapId = dgif.getMapId();
                this.dataGroupId = dgif.getDataGroupId();
                this.groupName = dgif.getDataGroupName();
                columnList = new ArrayList<>();
            }

            public void addColumn(DataGroupFieldRecord dgfi) {
                columnList.add(new DataGroupFieldInfo(dgfi.getFieldId(), dgfi.getFieldName(), DataType.valueOf(dgfi.getFieldType())));
            }

            public DataGroupInfo toDataGroupInfo() {
                return new DataGroupInfo(mapId, dataGroupId, groupName, columnList);
            }
        }
    }
}
