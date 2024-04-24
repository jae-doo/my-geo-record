package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldRecord;

import java.util.List;

@MybatisTest
class DataGroupMapperTest {
    @Autowired DataGroupMapper dataGroupMapper;

    @Test
    @DisplayName("사용자가 식별자로 DataGroupFieldInfo를 잘 가져오는지 확인")
    void getUserDataFieldInfoTest() {
        List<DataGroupFieldRecord> result = dataGroupMapper.findAllDataGroupInfoByUserId(1L);

        result.forEach(System.out::println);
    }

    @Test
    @DisplayName("지도 식별자로 DataGroupFieldInfo를 잘 가져오는지 확인")
    void getDataFieldInfoTest() {
        List<DataGroupFieldRecord> result = dataGroupMapper.findAllDataGroupInfoByGeoTableId(1L);

        result.forEach(System.out::println);
    }
}