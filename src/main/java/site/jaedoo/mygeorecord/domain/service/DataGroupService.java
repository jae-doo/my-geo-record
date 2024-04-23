package site.jaedoo.mygeorecord.domain.service;

import site.jaedoo.mygeorecord.domain.dto.DataGroupCreation;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;

import java.util.List;

public interface DataGroupService {
    List<DataGroupInfo> searchUserDataGroups(Long userId);
    List<DataGroupInfo> searchGeoTableDataGroups(Long userId, Long geoTableId);
    List<DataGroupInfo> createDataGroup(DataGroupCreation dataGroupCreation);
}
