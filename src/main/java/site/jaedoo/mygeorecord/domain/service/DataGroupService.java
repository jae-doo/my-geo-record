package site.jaedoo.mygeorecord.domain.service;

import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;

import java.util.List;

public interface DataGroupService {
    List<DataGroupInfo> searchUserDataGroups(Long userId);
    List<DataGroupInfo> searchGeoTableDataGroups(Long userId, Long geoTableId);
    List<DataGroupInfo> createDataGroup(Long userId, Long mapId, String dataGroupName, List<DataFieldInfo> dataFieldInfoList);
}
