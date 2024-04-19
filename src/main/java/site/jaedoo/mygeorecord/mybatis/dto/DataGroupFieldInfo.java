package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGroupFieldInfo {
    private Long mapId;
    private String mapName;
    private Long dataGroupId;
    private String dataGroupName;
    private String fieldName;
    private String fieldType;
}
