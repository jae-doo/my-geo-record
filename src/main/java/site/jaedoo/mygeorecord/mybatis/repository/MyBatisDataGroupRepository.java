package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.bytecode.FieldInfo;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.dto.DataGroupCreation;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.domain.entity.*;
import site.jaedoo.mygeorecord.domain.repository.DataGroupRepository;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupFieldInfo;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupInsert;
import site.jaedoo.mygeorecord.mybatis.dto.all.DataGroupField;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupFieldMapper;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupMapper;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

@Repository("dataGroupRepository")
@RequiredArgsConstructor
public class MyBatisDataGroupRepository implements DataGroupRepository {
    private final DataGroupMapper dataGroupMapper;
    private final DataGroupFieldMapper fieldMapper;

    @Override
    public List<DataGroup> findAllDataGroup() {
        List<DataGroupField<String>> dataGroupStringFields = dataGroupMapper.findAllDataGroupStringField();
        List<DataGroupField<Integer>> dataGroupNumberFields = dataGroupMapper.findAllDataGroupNumberField();

        Queue<DataGroupField> queue = new LinkedList<>();
        queue.addAll(dataGroupStringFields);
        queue.addAll(dataGroupNumberFields);
        queue = queue.stream().sorted(Comparator.comparingLong(DataGroupField::getRowId)).collect(Collectors.toCollection(LinkedList::new));

        Map<Long, DataGroup> dataGroups = new HashMap<>();

        while (!queue.isEmpty()) {
            DataGroupField dataGroupField = queue.peek();
            Long groupId = dataGroupField.getGroupId();
            Long rowId = dataGroupField.getRowId();

            if (!dataGroups.containsKey(groupId)) {
                List<Column> columns = new ArrayList<>();
                for (DataGroupField fields : queue) {
                    if (!Objects.equals(fields.getRowId(), rowId)) break;
                    columns.add(new Column(fields.getColumnName(), fields.getDataType()));
                }

                DataGroup dataGroup = DataGroup.builder().id(groupId)
                        .name(queue.peek().getGroupName())
                        .columns(columns)
                        .rows(new ArrayList<>())
                        .build();

                dataGroups.put(groupId, dataGroup);
            }

            DataGroup dataGroup = dataGroups.get(groupId);

            // Data 설정
            Map<String, Field> data = new HashMap<>();
            while (!queue.isEmpty() && Objects.equals(queue.peek().getRowId(), rowId)) {
                dataGroupField = queue.poll();
                String name = dataGroupField.getColumnName();
                Field field = new Field(dataGroupField.getData());
                data.put(name, field);
            }

            // Row 설정
            Row.RowBuilder rowBuilder = Row.builder();
            rowBuilder.latitude(dataGroupField.getLatitude());
            rowBuilder.longitude(dataGroupField.getLongitude());
            Row row = rowBuilder.data(data).build();

            dataGroup.getRows().add(row);
        }

        return new ArrayList<>(dataGroups.values());
    }

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
    public int insertDataGroup(DataGroupCreation dataGroupCreation) {
        DataGroupInsert dataGroupInsert = new DataGroupInsert(dataGroupCreation.mapId(), dataGroupCreation.dataGroupName());
        int dataGroupModified = dataGroupMapper.insertDataGroup(dataGroupInsert);

        Long dataGroupId = dataGroupInsert.getDataGroupId();
        int fieldModified = fieldMapper.insertDataGroupField(dataGroupId, dataGroupCreation.columnList());

        return dataGroupModified + fieldModified;
    }

    private static class DataGroupInfoCollector implements Collector<DataGroupFieldInfo, Map<Long, DataGroupInfoCollector.DataGroupStore>, List<DataGroupInfo>> {
        public Supplier<Map<Long, DataGroupStore>> supplier() {
            return HashMap::new;
        }

        public BiConsumer<Map<Long, DataGroupStore>, DataGroupFieldInfo> accumulator() {
            return (map, dataGroupFieldInfo) -> {
                map.computeIfAbsent(dataGroupFieldInfo.getDataGroupId(), (key) -> new DataGroupStore(dataGroupFieldInfo))
                        .addColumn(dataGroupFieldInfo);
            };
        }

        @Override
        public BinaryOperator<Map<Long, DataGroupStore>> combiner() {
            return (a, b) -> {
                b.entrySet().forEach((k)->a.put(k.getKey(),k.getValue()));
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
            return Collections.unmodifiableNavigableSet(
                    (NavigableSet<Characteristics>) EnumSet.of(Characteristics.IDENTITY_FINISH)
            );
        }

        @Data
        private static class DataGroupStore {
            Long mapId;
            Long dataGroupId;
            String groupName;
            List<Column> columnList;

            public DataGroupStore(DataGroupFieldInfo dgif) {
                this.mapId = dgif.getMapId();
                this.dataGroupId = dgif.getDataGroupId();
                this.groupName = dgif.getGroupName();
                columnList = new ArrayList<>();
            }

            public void addColumn(DataGroupFieldInfo dgfi) {
                columnList.add(new Column(dgfi.getFieldName(), DataType.valueOf(dgfi.getTypeName())));
            }

            public DataGroupInfo toDataGroupInfo() {
                return new DataGroupInfo(mapId, dataGroupId, groupName, columnList);
            }
        }
    }
}
