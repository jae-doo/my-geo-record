package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.GeoTable;

import java.util.List;
import java.util.Optional;

public interface GeoTableRepository {
    List<GeoTable> findAllGeoTable();
    List<GeoTable> findByUserId(Long userId);
    int countUserGeoTable(Long userId);
    boolean checkGeoTableName(Long userId, String name);
    Optional<GeoTable> insertGeoTable(Long userId, String name);
}
