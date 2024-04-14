package site.jaedoo.mygeorecord.mybatis.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import site.jaedoo.mygeorecord.domain.entity.DataGroup;
import site.jaedoo.mygeorecord.domain.repository.DataGroupRepository;
import site.jaedoo.mygeorecord.mybatis.mapper.DataGroupMapper;

import java.util.List;

@MybatisTest
@Import(MyBatisDataGroupRepository.class)
class MyBatisDataGroupRepositoryTest {
    @Autowired
    DataGroupRepository dataGroupRepository;
    @Autowired
    DataGroupMapper dataGroupMapper;

    @Test
    @DisplayName("DataGroup이 잘 생성되는지 확인")
    void findAllDataGroupTest() {
        List<DataGroup> dataGroups = dataGroupRepository.findAllDataGroup();
        System.out.println(dataGroups.size());
        dataGroups.forEach(System.out::println);
    }
}