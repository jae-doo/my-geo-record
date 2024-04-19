package site.jaedoo.mygeorecord.web.service.datagroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import site.jaedoo.mygeorecord.domain.dto.UserDataGroupInfo;
import site.jaedoo.mygeorecord.domain.repository.DataGroupRepository;
import site.jaedoo.mygeorecord.domain.service.DataGroupService;

import java.util.List;

@Component("dataGroupService")
@RequiredArgsConstructor
public class DefaultDataGroupService implements DataGroupService {
    private final DataGroupRepository dataGroupRepository;

    /**
     * 사용자의 모든 DataGroup을 조회합니다.
     * @param userId 사용자 식별자
     * @return 사용자의 DataGroup 정보를 담은 UserDataGroupInfo 리스트를 리턴
     */
    @Override
    public List<UserDataGroupInfo> findAllUsersDataGroup(Long userId) {
        return dataGroupRepository.findAllUserDataGroupInfo(userId);
    }
}
