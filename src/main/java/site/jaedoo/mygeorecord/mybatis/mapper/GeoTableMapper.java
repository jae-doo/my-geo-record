package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.mybatis.dto.geotable.GeoTableRecord;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GeoTableMapper {
    List<GeoTable> findGeoTableByUserId(Long userId);

    int countUserGeoTable(Long userId);

    Optional<GeoTable> findById(Long id);

    int insertGeoTable(GeoTableRecord geoTableDetails);

    int updateGeoTableName(Long id, String name);

    int deleteGeoTableById(Long id);
}
