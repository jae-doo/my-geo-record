package site.jaedoo.mygeorecord.mybatis.dto.datagroup;

import lombok.Data;

@Data
public class DataGroupFieldUpdate {
    private Long dataGroupFieldId;
    private Long order;
    private String dataGroupFieldName;
    private String dataGroupFieldType;
}
