package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.Data;

@Data
public class DataGroupStringField {
    private Long groupId;
    private String groupName;

    private Long columnId;
    private String columnName;
    private Long columnSeq;

    private Long recordId;
    private Double latitude;
    private Double longitude;

    private String data;
}
