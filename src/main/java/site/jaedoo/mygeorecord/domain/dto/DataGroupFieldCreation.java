package site.jaedoo.mygeorecord.domain.dto;

public record DataGroupFieldCreation(
        String fieldName,
        Long dataGroupId,
        String fieldType
) {
}
