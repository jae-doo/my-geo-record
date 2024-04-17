package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.repository.GeoTableRepository;
import site.jaedoo.mygeorecord.mybatis.mapper.GeoTableMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository("geoTableRepository")
public class MyBatisGeoTableRepository implements GeoTableRepository {
    private final GeoTableMapper geoTableMapper;

    @Override
    public List<GeoTable> findAllGeoTable() {
        return geoTableMapper.findAllGeoTable();
    }

    @Override
    public List<GeoTable> findByUserId(Long id) {
        return geoTableMapper.findGeoTableByUserId(id);
    }

    @Override
    public int countUserGeoTable(Long id) {
        return geoTableMapper.countUserGeoTable(id);
    }

    @Override
    public GeoTable insertGeoTable(Long id, String name) {
        geoTableMapper.insertGeoTable(id, name);
        return geoTableMapper
    }
}
