package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataGroupFieldInsert {
    private Long dataGroupFieldId;
    private String fieldName;
    private Long dataGroupId;
    private String fieldType;

    public DataGroupFieldInsert(String fieldName, Long dataGroupId, String fieldType) {
        this.fieldName = fieldName;
        this.dataGroupId = dataGroupId;
        this.fieldType = fieldType;
    }
}
