package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGroupFieldInfo {
    Long mapId;
    Long dataGroupId;
    String dataGroupName;
    String fieldName;
    String fieldType;
}
