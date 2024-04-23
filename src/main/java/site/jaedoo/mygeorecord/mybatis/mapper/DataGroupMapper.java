package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import site.jaedoo.mygeorecord.mybatis.dto.DataGroupFieldInfo;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupInsert;
import site.jaedoo.mygeorecord.mybatis.dto.all.DataGroupField;

import java.util.List;

@Mapper
public interface DataGroupMapper {
    List<DataGroupField<String>> findAllDataGroupStringField();
    List<DataGroupField<Integer>> findAllDataGroupNumberField();
    List<DataGroupFieldInfo> findAllDataGroupInfoByUserId(Long userId);
    List<DataGroupFieldInfo> findAllDataGroupInfoByGeoTableId(Long mapId);
    int insertDataGroup(DataGroupInsert dataGroupInsert);
}
