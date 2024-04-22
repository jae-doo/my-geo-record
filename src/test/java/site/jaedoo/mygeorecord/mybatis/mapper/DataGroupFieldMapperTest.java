package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupFieldCreation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class DataGroupFieldMapperTest {
    @Autowired DataGroupFieldMapper dataGroupFieldMapper;

    @Test
    @DisplayName("DataGroupField 삽입 로직 테스트")
    void insertDataGroupField() {
        // given
        List<DataFieldInfo> dataFieldInfoList = List.of(
                new DataFieldInfo("field1", "STRING"),
                new DataFieldInfo("field2", "STRING"),
                new DataFieldInfo("field3", "NUMBER")
        );
        DataGroupFieldCreation dgfc = new DataGroupFieldCreation(1L, dataFieldInfoList);

        // when
        int modified = dataGroupFieldMapper.insertDataGroupField(dgfc);

        // then
        assertThat(modified).isGreaterThan(0);
        assertThat(dgfc.getDataGroupId()).isNotNull();
    }
}