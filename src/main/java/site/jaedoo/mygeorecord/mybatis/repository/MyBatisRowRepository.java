package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.repository.RowRepository;

@Repository("rowRepository")
@RequiredArgsConstructor
public class MyBatisRowRepository implements RowRepository {
}
