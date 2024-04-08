package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.domain.entity.Column;

import java.util.List;

@Mapper
public interface ColumnMapper {
    List<Column> findAllColumn();
}
