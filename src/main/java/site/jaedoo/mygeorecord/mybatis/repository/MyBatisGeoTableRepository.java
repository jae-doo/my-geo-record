package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.repository.GeoTableRepository;
import site.jaedoo.mygeorecord.mybatis.mapper.GeoTableMapper;

import java.util.List;

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
}
