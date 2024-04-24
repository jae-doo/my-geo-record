package site.jaedoo.mygeorecord.mybatis.dto.datagroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.jaedoo.mygeorecord.domain.dto.DataGroupCreation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGroupInsert {
    private Long dataGroupId;

    private Long mapId;
    private String groupName;

    public DataGroupInsert(DataGroupCreation info) {
        this.mapId = info.mapId();
        this.groupName = info.dataGroupName();
    }
}
