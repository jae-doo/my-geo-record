package site.jaedoo.mygeorecord.web.service.map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.repository.GeoTableRepository;
import site.jaedoo.mygeorecord.domain.service.GeoTableService;
import site.jaedoo.mygeorecord.web.exception.geotable.GeoTableLimitExceededException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service("geoTableService")
public class DefaultGeoTableService implements GeoTableService {
    private final GeoTableRepository geoTableRepository;
    private final static int MAX_GEO_TABLE = 10;
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
     * 이때, 사용자가 이미 만든 지도가 {@link DefaultGeoTableService#MAX_GEO_TABLE} 이상이면, 지도 등록에 실패합니다.
     * @param userId 사용자 식별자
     * @param geoTableName 등록하려는 GeoTable 이름
     * @return 등록에 성공한 GeoTable 리턴
     * @throws GeoTableLimitExceededException 사용자의 지도 수가 {@link DefaultGeoTableService#MAX_GEO_TABLE} 이상이면 예외를 던집니다.
     */
    @Override
    public GeoTable registerGeoTable(Long userId, String geoTableName) {
        int numberOfGeoTable = geoTableRepository.countUserGeoTable(userId);
        if (numberOfGeoTable >= MAX_GEO_TABLE) throw new GeoTableLimitExceededException(MAX_GEO_TABLE);

        return geoTableRepository.insertGeoTable(userId, geoTableName);
    }
}
