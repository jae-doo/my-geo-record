package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.mybatis.dto.all.RowData;

import java.util.List;

@Mapper
public interface RowDataMapper {
    List<RowData<String>> findAllStringRowData();
    List<RowData<Integer>> findAllNumberRowData();
}
