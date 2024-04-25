package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldRecord;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupInsert;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupUpdate;

import java.util.List;

@Mapper
public interface DataGroupMapper {
    List<DataGroupFieldRecord> findAllDataGroupInfoByUserId(Long userId);
    List<DataGroupFieldRecord> findAllDataGroupInfoByGeoTableId(Long mapId);
    int insertDataGroup(DataGroupInsert dataGroupInsert);
    int updateDataGroup(DataGroupUpdate dataGroupUpdate);
    int deleteDataGroup(Long dataGroupId);
}
