package site.jaedoo.mygeorecord.mybatis.dto.datagroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import site.jaedoo.mygeorecord.domain.dto.DataGroupFieldEdit;

@Data
@AllArgsConstructor
public class DataGroupFieldUpdate {
    private Long dataGroupFieldId;
    private Integer order;
    private String dataGroupFieldName;
    private String dataGroupFieldType;

    public DataGroupFieldUpdate(DataGroupFieldEdit edit) {
        this.dataGroupFieldId = edit.fieldId();
        this.order = edit.order();
        this.dataGroupFieldName = edit.fieldName();
        this.dataGroupFieldType = edit.fieldType();
    }
}
