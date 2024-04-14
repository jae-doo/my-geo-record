package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.Field;
import site.jaedoo.mygeorecord.domain.repository.FieldRepository;
import site.jaedoo.mygeorecord.mybatis.mapper.FieldValueMapper;

import java.util.List;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class MyBatisFieldRepository implements FieldRepository {
    private final FieldValueMapper fieldValueMapper;

    @Override
    public List<Field> findAllField() {
        return Stream.of(fieldValueMapper.findAllNumberValues(), fieldValueMapper.findAllStringValues())
                .flatMap(List::stream)
                .map(Field::new)
                .map(f -> (Field) f)
                .toList();
    }
}
