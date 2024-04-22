package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupFieldCreation;

@Mapper
public interface DataGroupFieldMapper {
    int insertDataGroupField(DataGroupFieldCreation dataGroupFieldCreation);
}
