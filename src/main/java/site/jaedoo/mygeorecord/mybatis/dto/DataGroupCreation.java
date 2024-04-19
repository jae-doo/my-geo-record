package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGroupCreation {
    private Long dataGroupId;

    private Long mapId;
    private String mapName;
    private String groupName;
    private List<DataFieldInfo> dataFieldInfoList;

    public DataGroupCreation(Long mapId, String mapName, String groupName, List<DataFieldInfo> dataFieldInfoList) {
        this.mapId = mapId;
        this.mapName = mapName;
        this.groupName = groupName;
        this.dataFieldInfoList = dataFieldInfoList;
    }
}
