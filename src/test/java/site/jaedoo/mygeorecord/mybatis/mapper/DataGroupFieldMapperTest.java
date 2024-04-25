package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.domain.entity.DataType;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldInsert;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldUpdate;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.DataGroupFieldForm;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class DataGroupFieldMapperTest {
    @Autowired DataGroupFieldMapper dataGroupFieldMapper;

    @Test
    @DisplayName("DataGroupField Bulk 삽입 로직 테스트")
    void bulkInsertTest() {
        // given
        Long dataGroupId = 1L;
        List<DataGroupFieldInsert> fieldInsertList = Stream.of(
                new DataGroupFieldForm("field1", "STRING"),
                new DataGroupFieldForm("field2", "STRING"),
                new DataGroupFieldForm("field3", "NUMBER")
        )
                .map(DataGroupFieldForm::toColumn)
                .map(c -> new DataGroupFieldInsert(dataGroupId, c))
                .toList();

        // when
        int modified = dataGroupFieldMapper.batchInsertDataGroupField(1L, fieldInsertList);

        // then
        assertThat(modified).isGreaterThan(0);
    }

    @Test
    @DisplayName("DataGroupField 삽입 로직 테스트")
    void insertTest() {
        // given
        Long dataGroupId = 1L;
        Column column = new Column("column", DataType.URL);
        DataGroupFieldInsert insert = new DataGroupFieldInsert(dataGroupId, column);

        // when
        int modified = dataGroupFieldMapper.insertDataGroupField(insert);

        // then
        assertThat(modified).isGreaterThan(0);
    }

    @Test
    @DisplayName("DataGroupField 갱신 로직 테스트")
    void updateTest() {
        // given
        Long dataGroupId = 1L;
        Column column = new Column("column", DataType.URL);
        DataGroupFieldInsert insert = new DataGroupFieldInsert(dataGroupId, column);
        dataGroupFieldMapper.insertDataGroupField(insert);

        Long fieldId = insert.getDataGroupFieldId();
        DataGroupFieldUpdate update = new DataGroupFieldUpdate(fieldId, 4, "test", DataType.STRING.toString());

        // when
        int modified = dataGroupFieldMapper.updateDataGroupField(update);

        // then
        assertThat(modified).isGreaterThan(0);
    }

}