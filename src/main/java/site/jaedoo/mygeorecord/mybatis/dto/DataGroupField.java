package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.Data;
import site.jaedoo.mygeorecord.domain.entity.DataType;

@Data
public class DataGroupField<T> {
    private Long groupId;
    private String groupName;

    private Long columnId;
    private String columnName;
    private Long columnSeq;

    private Long rowId;
    private Double latitude;
    private Double longitude;

    private DataType dataType;

    private T data;
}
