package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.mybatis.dto.DataGroupField;
import site.jaedoo.mygeorecord.mybatis.dto.UserDataGroupFieldInfo;

import java.util.List;

@Mapper
public interface DataGroupMapper {
    List<DataGroupField<String>> findAllDataGroupStringField();
    List<DataGroupField<Integer>> findAllDataGroupNumberField();
    List<UserDataGroupFieldInfo> findAllUserDataGroupFieldInfo(Long userId);
}
