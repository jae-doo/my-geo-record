package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGroupFieldCreation {
    private Long dataGroupId;
    private List<DataFieldInfo> dataFieldInfoList;
}
