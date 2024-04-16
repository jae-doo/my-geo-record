package site.jaedoo.mygeorecord.domain.service;

import site.jaedoo.mygeorecord.domain.entity.GeoTable;

import java.util.List;

public interface GeoTableService {
    List<GeoTable> findUserMaps(Long userId);
    GeoTable registerGeoTable(Long userId, String name);
}
