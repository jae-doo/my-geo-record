package site.jaedoo.mygeorecord.mybatis.dto.datagroup;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataGroupFieldRecord {
    Long mapId;
    Long dataGroupId;
    String dataGroupName;
    Long fieldId;
    String fieldName;
    String fieldType;
}
