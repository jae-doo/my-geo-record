package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.domain.dto.DataGroupFieldInfo;
import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldInsert;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.DataGroupFieldForm;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class DataGroupFieldMapperTest {
    @Autowired DataGroupFieldMapper dataGroupFieldMapper;

    @Test
    @DisplayName("DataGroupField 삽입 로직 테스트")
    void insertDataGroupField() {
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
}