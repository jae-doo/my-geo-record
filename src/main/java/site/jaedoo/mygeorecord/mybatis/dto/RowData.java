package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.Data;

@Data
public class RowData<T> {
    private double latitude;
    private double longitude;
    private String fieldName;
    private T data;
}
