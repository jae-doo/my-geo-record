package site.jaedoo.mygeorecord.domain.dto;

import site.jaedoo.mygeorecord.domain.entity.Column;

import java.util.List;

public record DataGroupCreation(
        Long userId,
        Long mapId,
        String dataGroupName,
        List<Column> columnList
) {
}
