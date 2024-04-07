package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupField;

import java.util.List;

@Mapper
public interface DataGroupMapper {
    List<DataGroupField<String>> findAllDataGroupStringField();
    List<DataGroupField<Integer>> findAllDataGroupNumberField();
}
