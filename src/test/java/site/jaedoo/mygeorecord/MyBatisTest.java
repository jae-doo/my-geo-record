package site.jaedoo.mygeorecord;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.mybatis.mapper.*;

@MybatisTest
public class MyBatisTest {
    @Autowired GeoTableMapper geoTableMapper;
    @Autowired UserMapper userMapper;
    @Autowired DataGroupMapper dataGroupMapper;
    @Autowired ColumnMapper columnMapper;
    @Autowired FieldValueMapper fieldValueMapper;
    @Autowired RowDataMapper rowDataMapper;

    @Test
    @DisplayName("Mapper가 제대로 동작하는지 확인")
    void getResource() {
        Assertions.assertThat(geoTableMapper.findAllGeoTable()).isNotEmpty();
        Assertions.assertThat(userMapper.findAllUser()).isNotEmpty();
        Assertions.assertThat(dataGroupMapper.findAllDataGroupStringField()).isNotEmpty();
        Assertions.assertThat(dataGroupMapper.findAllDataGroupNumberField()).isNotEmpty();
        Assertions.assertThat(columnMapper.findAllColumn()).isNotEmpty();
        Assertions.assertThat(fieldValueMapper.findAllStringValues()).isNotEmpty();
        Assertions.assertThat(fieldValueMapper.findAllNumberValues()).isNotEmpty();
        Assertions.assertThat(rowDataMapper.findAllStringRowData()).isNotEmpty();
        Assertions.assertThat(rowDataMapper.findAllNumberRowData()).isNotEmpty();
    }
}
