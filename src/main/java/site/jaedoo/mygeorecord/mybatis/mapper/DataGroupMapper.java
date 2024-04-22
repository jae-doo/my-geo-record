package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupCreation;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupField;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupFieldCreation;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupFieldInfo;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DataGroupMapper {
    List<DataGroupField<String>> findAllDataGroupStringField();
    List<DataGroupField<Integer>> findAllDataGroupNumberField();
    List<DataGroupFieldInfo> findAllDataGroupFieldInfoByUserId(Long userId);
    List<DataGroupFieldInfo> findAllDataGroupFieldInfoByGeoTableId(Long mapId);
    int insertDataGroup(DataGroupCreation dataGroupCreation);
}
