package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.repository.GeoTableRepository;
import site.jaedoo.mygeorecord.mybatis.dto.GeoTableDetails;
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
    public List<GeoTable> findByUserId(Long userId) {
        return geoTableMapper.findGeoTableByUserId(userId);
    }

    @Override
    public int countUserGeoTable(Long userId) {
        return geoTableMapper.countUserGeoTable(userId);
    }

    @Override
    public Optional<GeoTable> findById(Long id) { return geoTableMapper.findById(id); }

    @Override
    public GeoTable insertGeoTable(Long userId, String name) {
        GeoTableDetails geoTableDetails = new GeoTableDetails(userId, name);
        geoTableMapper.insertGeoTable(geoTableDetails);
        return new GeoTable(geoTableDetails.getId(), geoTableDetails.getName(), userId);
    }

    @Override
    public int updateGeoTableName(Long id, String name) {
        return geoTableMapper.updateGeoTableName(id, name);
    }

    @Override
    public int deleteGeoTableById(Long id) {
        return geoTableMapper.deleteGeoTableById(id);
    }
}
