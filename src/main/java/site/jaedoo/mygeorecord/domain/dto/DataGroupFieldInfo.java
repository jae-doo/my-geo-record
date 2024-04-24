package site.jaedoo.mygeorecord.domain.dto;

import site.jaedoo.mygeorecord.domain.entity.DataType;

public record DataGroupFieldInfo(
        Long fieldId,
        String fieldName,
        DataType fieldType
) {
}
