package site.jaedoo.mygeorecord.domain.dto;

import java.util.List;

public record DataGroupInsertInfo(
        Long userId,
        Long mapId,
        String dataGroupName,
        List<DataFieldInfo> dataFieldInfoList
) {
}
