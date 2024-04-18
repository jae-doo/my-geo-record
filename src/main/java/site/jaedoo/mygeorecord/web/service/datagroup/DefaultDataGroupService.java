package site.jaedoo.mygeorecord.web.service.datagroup;

import org.springframework.stereotype.Component;
import site.jaedoo.mygeorecord.domain.dto.UserDataGroupInfo;
import site.jaedoo.mygeorecord.domain.service.DataGroupService;

import java.util.List;

@Component
public class DefaultDataGroupService implements DataGroupService {

    @Override
    public List<UserDataGroupInfo> findAllUsersDataGroup(Long userId) {
        return null;
    }
}
