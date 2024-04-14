package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FieldValueMapper {
    List<String> findAllStringValues();
    List<Integer> findAllNumberValues();
}
