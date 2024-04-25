package site.jaedoo.mygeorecord.mybatis.repository;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import site.jaedoo.mygeorecord.domain.dto.DataGroupCreation;
import site.jaedoo.mygeorecord.domain.dto.DataGroupFieldInfo;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.domain.entity.DataType;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldRecord;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupFieldMapper;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyBatisDataGroupRepositoryTest {
    @Mock
    DataGroupMapper dataGroupMapper;
    @Mock
    DataGroupFieldMapper dataGroupFieldMapper;
    @InjectMocks
    MyBatisDataGroupRepository dataGroupRepository;

    static Long userId = 1L;
    static Long mapId = 1L;
    static Long groupId = 1L;
    static String groupName = "group1";
    static List<Column> columnList = List.of(
            new Column("field1", DataType.NUMBER),
            new Column("field2", DataType.NUMBER),
            new Column("field3", DataType.STRING)
    );

    @Test
    void findAllUserDataGroupInfo() {
        // given
        List<DataGroupFieldRecord> expected = columnList.stream()
                .map(c -> new DataGroupFieldRecord(mapId, groupId, groupName, 1L, c.getName(), c.getType().toString()))
                        .toList();
        when(dataGroupMapper.findAllDataGroupInfoByUserId(userId)).thenReturn(expected);

        // when
        List<DataGroupInfo> actual = dataGroupRepository.findAllUserDataGroupInfo(userId);

        // then
        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).dataGroupId()).isEqualTo(groupId);
        assertThat(actual.get(0).groupName()).isEqualTo(groupName);
        assertThat(actual.get(0).mapId()).isEqualTo(mapId);
        assertThat(actual.get(0).fieldList()).hasSize(3)
                .map(DataGroupFieldInfo::fieldId, DataGroupFieldInfo::fieldName, DataGroupFieldInfo::fieldType)
                .contains(new Tuple(1L, "field1", DataType.NUMBER),
                        new Tuple(1L, "field2", DataType.NUMBER),
                        new Tuple(1L, "field3", DataType.STRING));
    }

    @Test
    void findAllGeoTableDataGroupInfo() {
        // given
        List<DataGroupFieldRecord> expected = columnList.stream()
                .map(c -> new DataGroupFieldRecord(mapId, groupId, groupName, 1L, c.getName(), c.getType().toString()))
                .toList();
        when(dataGroupMapper.findAllDataGroupInfoByGeoTableId(mapId)).thenReturn(expected);

        // when
        List<DataGroupInfo> actual = dataGroupRepository.findAllGeoTableDataGroupInfo(userId, groupId);

        // then
        assertThat(actual.get(0).fieldList()).hasSize(3)
                .map(DataGroupFieldInfo::fieldId, DataGroupFieldInfo::fieldName, DataGroupFieldInfo::fieldType)
                .contains(new Tuple(1L, "field1", DataType.NUMBER),
                        new Tuple(1L, "field2", DataType.NUMBER),
                        new Tuple(1L, "field3", DataType.STRING));
    }

    @Test
    void insertDataGroup() {
        // given
        new DataGroupCreation(userId, mapId, groupName, columnList);

    }

    @Test
    void updateDataGroup() {
    }

    @Test
    void deleteDataGroup() {
    }

    @Test
    void insertDataGroupField() {
    }

    @Test
    void updateDataGroupField() {
    }

    @Test
    void deleteDataGroupField() {
    }
}