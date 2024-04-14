package site.jaedoo.mygeorecord.mybatis.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import site.jaedoo.mygeorecord.domain.entity.Row;
import site.jaedoo.mygeorecord.domain.repository.RowRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@Import(MyBatisRowRepository.class)
class MyBatisRowRepositoryTest {
    @Autowired RowRepository rowRepository;

    @Test
    @DisplayName("RowRepository가 제대로 동작하는지 확인")
    void rowRepositoryTest() {
        List<Row> rows = rowRepository.findAllRow();
        System.out.println(rows.size());
        rows.forEach(System.out::println);
    }
}