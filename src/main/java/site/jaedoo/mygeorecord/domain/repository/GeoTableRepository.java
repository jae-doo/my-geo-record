package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.GeoTable;

import java.util.List;
import java.util.Optional;

public interface GeoTableRepository {
    List<GeoTable> findAllGeoTable();
    List<GeoTable> findByUserId(Long id);
    int countUserGeoTable(Long id);
    GeoTable insertGeoTable(Long id, String name);
}
