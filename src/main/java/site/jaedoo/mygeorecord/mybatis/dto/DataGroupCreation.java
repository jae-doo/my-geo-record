package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGroupCreation {
    private Long dataGroupId;

    private Long mapId;
    private String groupName;

    public DataGroupCreation(Long mapId, String groupName) {
        this.mapId = mapId;
        this.groupName = groupName;
    }
}
