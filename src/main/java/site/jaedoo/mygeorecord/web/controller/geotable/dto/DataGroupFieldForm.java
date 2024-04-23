package site.jaedoo.mygeorecord.web.controller.geotable.dto;

import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.domain.entity.DataType;

public record DataGroupFieldForm(
        String fieldName,
        String typeName
) {
    public Column toColumn() {
        return new Column(fieldName, DataType.valueOf(typeName));
    }
}
