package site.jaedoo.mygeorecord.web.service.datagroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import site.jaedoo.mygeorecord.domain.dto.DataFieldInfo;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInsertInfo;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.repository.DataGroupRepository;
import site.jaedoo.mygeorecord.domain.repository.GeoTableRepository;
import site.jaedoo.mygeorecord.domain.service.DataGroupService;
import site.jaedoo.mygeorecord.web.exception.user.UserAuthenticationException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component("dataGroupService")
@RequiredArgsConstructor
public class DefaultDataGroupService implements DataGroupService {
    private final DataGroupRepository dataGroupRepository;
    private final GeoTableRepository geoTableRepository;

    /**
     * 사용자의 모든 DataGroup을 조회합니다.
     * @param userId 사용자 식별자
     * @return 사용자의 DataGroup 정보를 담은 DataGroupInfo 리스트를 리턴
     */
    @Override
    public List<DataGroupInfo> searchUserDataGroups(Long userId) {
        return dataGroupRepository.findAllUserDataGroupInfo(userId);
    }

    /**
     * Map에 있는 모든 DataGroup을 조회합니다.
     * @param userId 사용자 식별자
     * @param geoTableId GeoTable(Map) 식별자
     * @return 사용자가 소유한 지도에 대한 모든 DataGroup을 리턴
     * @throws UserAuthenticationException 조회하려는 지도가 사용자의 소유가 아닐 때 예외를 던집니다.
     */
    @Override
    @Transactional
    public List<DataGroupInfo> searchGeoTableDataGroups(Long userId, Long geoTableId) {
        Optional<GeoTable> optionalGeoTable = geoTableRepository.findById(geoTableId);

        optionalGeoTable.filter((GeoTable g)-> Objects.equals(g.getOwner(), userId))
                .orElseThrow(UserAuthenticationException::new);

        return dataGroupRepository.findAllGeoTableDataGroupInfo(userId, geoTableId);
    }

    /**
     *
     * @param dataGroupName
     * @param dataFieldInfoList
     * @return
     */
    @Override
    @Transactional
    public List<DataGroupInfo> createDataGroup(Long userId, Long mapId, String dataGroupName, List<DataFieldInfo> dataFieldInfoList) {
        DataGroupInsertInfo insertInfo = new DataGroupInsertInfo(userId, mapId, dataGroupName, dataFieldInfoList);
        int result = dataGroupRepository.insertDataGroup(insertInfo);

        if (result <= 0) throw new UserAuthenticationException();

        return dataGroupRepository.findAllGeoTableDataGroupInfo(userId, mapId);
    }
}
