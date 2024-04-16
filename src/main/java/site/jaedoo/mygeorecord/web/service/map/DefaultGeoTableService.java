package site.jaedoo.mygeorecord.web.service.map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.repository.GeoTableRepository;
import site.jaedoo.mygeorecord.domain.service.GeoTableService;

import java.util.List;

@RequiredArgsConstructor
@Service("geoTableService")
public class DefaultGeoTableService implements GeoTableService {
    private final GeoTableRepository geoTableRepository;
    @Override
    public List<GeoTable> findUserMaps(Long userId) {
        return geoTableRepository.findByUserId(userId);
    }
}
