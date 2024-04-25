package site.jaedoo.mygeorecord.domain.dto;

public record DataGroupFieldEdit(
        Long fieldId,
        Integer order,
        String fieldName,
        String fieldType
) {}
