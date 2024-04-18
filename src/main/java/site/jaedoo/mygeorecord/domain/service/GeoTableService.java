package site.jaedoo.mygeorecord.domain.service;

import site.jaedoo.mygeorecord.domain.entity.GeoTable;

import java.util.List;

public interface GeoTableService {
    List<GeoTable> findUserMaps(Long userId);
    GeoTable registerGeoTable(Long userId, String name);
    GeoTable updateGeoTable(Long id, Long userId, String name);
    boolean deleteGeoTable(Long id, Long userId);
}
