package site.jaedoo.mygeorecord.mybatis.dto.datagroup;

import lombok.Data;
import lombok.NoArgsConstructor;
import site.jaedoo.mygeorecord.domain.dto.DataGroupFieldCreation;
import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.domain.entity.DataGroup;

@Data
public class DataGroupFieldInsert {
    private Long dataGroupFieldId;
    private Long dataGroupId;
    private String fieldName;
    private String fieldType;

    public DataGroupFieldInsert(DataGroupFieldCreation info) {
        this.dataGroupId = info.dataGroupId();
        this.fieldName = info.fieldName();
        this.fieldType = info.fieldType();
    }

    public DataGroupFieldInsert(Long dataGroupId, Column column) {
        this.dataGroupId = dataGroupId;
        this.fieldName = column.getName();
        this.fieldType = column.getType().toString();
    }
}
