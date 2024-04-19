package site.jaedoo.mygeorecord.domain.dto;

import java.util.Collections;
import java.util.List;

public record DataGroupInfo(
        Long mapId,
        String mapName,
        Long dataGroupId,
        Long ownerId,
        String groupName,
        List<DataFieldInfo> dataFieldInfoList
) {
    public DataGroupInfo(Long mapId, String mapName, Long dataGroupId, Long ownerId, String groupName, List<DataFieldInfo> dataFieldInfoList) {
        this.mapId = mapId;
        this.mapName = mapName;
        this.dataGroupId = dataGroupId;
        this.ownerId = ownerId;
        this.groupName = groupName;
        this.dataFieldInfoList = Collections.unmodifiableList(dataFieldInfoList);
    }
}
