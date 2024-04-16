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

    /**
     * 사용자가 만든 모든 지도를 조회합니다.
     * @param userId 사용자 식별자
     * @return 사용자가 가진 모든 지도를 리턴
     */
    @Override
    public List<GeoTable> findUserMaps(Long userId) {
        return geoTableRepository.findByUserId(userId);
    }

    /**
     * 사용자의 식별자와 지도 이름을 받아서 새로운 지도를 등록합니다.
     * 이때, 사용자가 이미 만든 지도가 10개 이상이면, 지도 등록에 실패합니다.
     * @param userId 사용자 식별자
     * @param geoTableName 등록하려는 GeoTable 이름
     * @return 등록에 성공한 GeoTable 리턴
     */
    @Override
    public GeoTable registerGeoTable(Long userId, String geoTableName) {
        // todo
        return null;
    }
}
