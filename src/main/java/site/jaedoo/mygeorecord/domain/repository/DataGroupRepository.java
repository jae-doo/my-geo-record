package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.dto.*;

import java.util.List;

public interface DataGroupRepository {
    List<DataGroupInfo> findAllUserDataGroupInfo(Long userId);
    List<DataGroupInfo> findAllGeoTableDataGroupInfo(Long userId, Long geoTableId);
    int insertDataGroup(DataGroupCreation info);
    int updateDataGroup(DataGroupEdit info);
    int insertDataGroupField(DataGroupFieldCreation info);
    int updateDataGroupField(DataGroupFieldEdit info);
}