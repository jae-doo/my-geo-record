package site.jaedoo.mygeorecord.web.controller.geotable.dto;

import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;

import java.util.Collections;
import java.util.List;

public record DataGroupForm(
        String name,
        List<DataFieldInfo> fieldInfoList
) {
    public DataGroupForm(String name, List<DataFieldInfo> fieldInfoList) {
        this.name = name;
        this.fieldInfoList = Collections.unmodifiableList(fieldInfoList);
    }
}
