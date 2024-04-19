package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.domain.entity.DataGroup;

import java.util.List;
import java.util.Optional;

public interface DataGroupRepository {
    List<DataGroup> findAllDataGroup();
    List<DataGroupInfo> findAllUserDataGroupInfo(Long userId);
    List<DataGroupInfo> findAllGeoTableDataGroupInfo(Long userId, Long geoTableId);
    Optional<DataGroupInfo> insertDataGroup(Long mapId, String dataGroupName, List<DataFieldInfo> dataGroupFieldInfoList);
}
