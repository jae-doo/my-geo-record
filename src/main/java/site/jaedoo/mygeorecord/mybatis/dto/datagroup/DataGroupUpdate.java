package site.jaedoo.mygeorecord.mybatis.dto.datagroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import site.jaedoo.mygeorecord.domain.dto.DataGroupEdit;

@Data
@AllArgsConstructor
public class DataGroupUpdate {
    private Long dataGroupId;
    private String dataGroupName;

    public DataGroupUpdate(DataGroupEdit dataGroupEdit) {
        this.dataGroupId = dataGroupEdit.dataGroupId();
        this.dataGroupName = dataGroupEdit.dataGroupName();
    }
}
