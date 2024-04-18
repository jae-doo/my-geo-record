package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.GeoTable;

import java.util.List;
import java.util.Optional;

public interface GeoTableRepository {
    List<GeoTable> findAllGeoTable();

    List<GeoTable> findByUserId(Long userId);

    int countUserGeoTable(Long userId);

    Optional<GeoTable> findById(Long id);

    GeoTable insertGeoTable(Long userId, String name);

    Optional<GeoTable> updateGeoTableName(Long id, String name);

    int deleteGeoTableById(Long id);
}
