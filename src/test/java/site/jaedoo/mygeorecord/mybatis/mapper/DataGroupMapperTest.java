package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.mybatis.dto.UserDataGroupFieldInfo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
class DataGroupMapperTest {
    @Autowired DataGroupMapper dataGroupMapper;

    @Test
    @DisplayName("userDataGroupFieldInfo를 잘 가져오는지 확인")
    void getUserDataFieldInfoTest() {
        List<UserDataGroupFieldInfo> result = dataGroupMapper.findAllUserDataGroupFieldInfo(1L);

        result.forEach(System.out::println);
    }
}