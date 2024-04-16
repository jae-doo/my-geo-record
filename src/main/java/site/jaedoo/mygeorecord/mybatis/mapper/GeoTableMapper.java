package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;

import java.util.List;

@Mapper
public interface GeoTableMapper {
    List<GeoTable> findAllGeoTable();

    List<GeoTable> findGeoTableByUserId(Long id);

    int countUserGeoTable(Long id);
}
