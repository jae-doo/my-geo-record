package site.jaedoo.mygeorecord.domain.dto;

public record DataGroupEdit(
        Long userId,
        Long mapId,
        Long dataGroupId,
        String dataGroupName
) {}
