package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.GeoTable;

import java.util.List;

public interface GeoTableRepository {
    List<GeoTable> findAllGeoTable();
}
