package site.jaedoo.mygeorecord.domain.dto;

import java.util.List;

public record DataGroupInfo(
        Long mapId,
        Long dataGroupId,
        String groupName,
        List<DataGroupFieldInfo> fieldList
) {}
