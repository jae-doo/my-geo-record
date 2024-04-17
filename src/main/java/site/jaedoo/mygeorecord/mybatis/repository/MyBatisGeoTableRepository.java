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
    public List<GeoTable> findByUserId(Long userId) {
        return geoTableMapper.findGeoTableByUserId(userId);
    }

    @Override
    public int countUserGeoTable(Long userId) {
        return geoTableMapper.countUserGeoTable(userId);
    }

    @Override
    public boolean checkGeoTableName(Long userId, String name) {
        return geoTableMapper.findGeoTableByUserIdAndName(userId, name).isPresent();
    }

    @Override
    public Optional<GeoTable> insertGeoTable(Long userId, String name) {
        if (checkGeoTableName(userId, name)) return Optional.empty();
        geoTableMapper.insertGeoTable(userId, name);
        return geoTableMapper.findGeoTableByUserIdAndName(userId, name);
    }
}
