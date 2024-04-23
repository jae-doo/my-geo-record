package site.jaedoo.mygeorecord.web.controller.geotable.dto;

import java.util.Collections;
import java.util.List;

public record DataGroupForm(
        String name,
        List<DataGroupFieldForm> fieldInfoList
) {
    public DataGroupForm(String name, List<DataGroupFieldForm> fieldInfoList) {
        this.name = name;
        this.fieldInfoList = Collections.unmodifiableList(fieldInfoList);
    }
}
