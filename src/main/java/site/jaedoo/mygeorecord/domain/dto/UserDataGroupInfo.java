package site.jaedoo.mygeorecord.domain.dto;

import site.jaedoo.mygeorecord.mybatis.dto.UserDataGroupFieldInfo;

import java.util.Collections;
import java.util.List;

public record UserDataGroupInfo(
        Long mapId,
        String mapName,
        Long dataGroupId,
        Long ownerId,
        String groupName,
        List<DataFieldInfo> dataFieldInfoList
) {
    public UserDataGroupInfo(Long mapId, String mapName, Long dataGroupId, Long ownerId, String groupName, List<DataFieldInfo> dataFieldInfoList) {
        this.mapId = mapId;
        this.mapName = mapName;
        this.dataGroupId = dataGroupId;
        this.ownerId = ownerId;
        this.groupName = groupName;
        this.dataFieldInfoList = Collections.unmodifiableList(dataFieldInfoList);
    }
}
