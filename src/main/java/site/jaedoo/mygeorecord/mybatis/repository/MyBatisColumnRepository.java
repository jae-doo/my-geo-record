package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.domain.repository.ColumnRepository;
import site.jaedoo.mygeorecord.mybatis.mapper.ColumnMapper;

import java.util.List;

@Repository("columnRepository")
@RequiredArgsConstructor
public class MyBatisColumnRepository implements ColumnRepository {
    private final ColumnMapper columnMapper;

    @Override
    public List<Column> findAllColumn() {
        return columnMapper.findAllColumn();
    }
}
