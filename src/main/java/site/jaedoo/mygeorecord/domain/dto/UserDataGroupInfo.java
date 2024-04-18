package site.jaedoo.mygeorecord.domain.dto;

import java.util.Collections;
import java.util.List;

public record UserDataGroupInfo(
        Long dataGroupId,
        Long ownerId,
        String groupName,
        List<DataFieldInfo> dataFieldInfoList
) {
    public UserDataGroupInfo(Long dataGroupId, Long ownerId, String groupName, List<DataFieldInfo> dataFieldInfoList) {
        this.dataGroupId = dataGroupId;
        this.ownerId = ownerId;
        this.groupName = groupName;
        this.dataFieldInfoList = Collections.unmodifiableList(dataFieldInfoList);
    }
}
