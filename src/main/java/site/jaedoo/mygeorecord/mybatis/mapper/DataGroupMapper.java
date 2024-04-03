package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupStringField;

import java.util.List;

@Mapper
public interface DataGroupMapper {
    List<DataGroupStringField> findAllDataGroupStringField();
}
