package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.repository.ColumnRepository;

@Repository("columnRepository")
@RequiredArgsConstructor
public class MyBatisColumnRepository implements ColumnRepository {
}
