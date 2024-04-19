package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.domain.entity.DataGroup;

import java.util.List;

public interface DataGroupRepository {
    List<DataGroup> findAllDataGroup();
    List<DataGroupInfo> findAllUserDataGroupInfo(Long userId);
    List<DataGroupInfo> findAllGeoTableDataGroupInfo(Long userId, Long geoTableId);
}
