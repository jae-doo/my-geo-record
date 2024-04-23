package site.jaedoo.mygeorecord.mybatis.dto.all;

import lombok.Data;
import site.jaedoo.mygeorecord.domain.entity.Field;

@Data
public class RowData<T> {
    private Long rowId;
    private double latitude;
    private double longitude;
    private String fieldName;
    private T data;

    public Field<T> getField() {
        return new Field<>(data);
    }
}
