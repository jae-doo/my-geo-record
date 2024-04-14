package site.jaedoo.mygeorecord.mybatis.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import site.jaedoo.mygeorecord.domain.entity.Field;

import java.util.List;

@MybatisTest
@Import(MyBatisFieldRepository.class)
class MyBatisFieldRepositoryTest {
    @Autowired MyBatisFieldRepository fieldRepository;

    @Test
    @DisplayName("field repository가 제대로 동작하는지 확인")
    void fieldRepositoryTest() {
        List<Field> fields = fieldRepository.findAllField();
        System.out.println(fields.size());
        fields.forEach(System.out::println);
    }
}