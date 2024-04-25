package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldInsert;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldUpdate;

import java.util.List;

@Mapper
public interface DataGroupFieldMapper {
    int batchInsertDataGroupField(Long dataGroupId, List<DataGroupFieldInsert> columnList);
    int insertDataGroupField(DataGroupFieldInsert dataGroupFieldInsert);
    int updateDataGroupField(DataGroupFieldUpdate dataGroupFieldUpdate);
    int deleteDataGroupField(Long dataGroupFieldId);
}
