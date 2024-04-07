package site.jaedoo.mygeorecord;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupMapper;
import site.jaedoo.mygeorecord.mybatis.mapper.GeoTableMapper;
import site.jaedoo.mygeorecord.mybatis.mapper.UserMapper;

@MybatisTest
public class MyBatisTest {
    @Autowired GeoTableMapper geoTableMapper;
    @Autowired UserMapper userMapper;
    @Autowired DataGroupMapper dataGroupMapper;

    @Test
    @DisplayName("Mapper가 제대로 동작하는지 확인")
    void getResource() {
        System.out.println(geoTableMapper.findAllGeoTable());
        System.out.println(userMapper.findAllUser());
        System.out.println(dataGroupMapper.findAllDataGroupStringField());
        System.out.println(dataGroupMapper.findAllDataGroupNumberField());
    }
}
