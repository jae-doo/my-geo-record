package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.dto.UserDataGroupInfo;
import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.domain.entity.DataGroup;
import site.jaedoo.mygeorecord.domain.entity.Field;
import site.jaedoo.mygeorecord.domain.entity.Row;
import site.jaedoo.mygeorecord.domain.repository.DataGroupRepository;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupField;
import site.jaedoo.mygeorecord.mybatis.dto.UserDataGroupFieldInfo;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupMapper;

import java.util.*;
import java.util.stream.Collectors;

@Repository("dataGroupRepository")
@RequiredArgsConstructor
public class MyBatisDataGroupRepository implements DataGroupRepository {
    private final DataGroupMapper dataGroupMapper;

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
                    if (fields.getRowId() != rowId) break;
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
            while (!queue.isEmpty() && queue.peek().getRowId() == rowId) {
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
    public List<UserDataGroupInfo> findAllUserDataGroupInfo(Long userId) {
        // todo
        List<UserDataGroupFieldInfo> allUserDataGroupFieldInfo = dataGroupMapper.findAllUserDataGroupFieldInfo(userId);
    }
}
