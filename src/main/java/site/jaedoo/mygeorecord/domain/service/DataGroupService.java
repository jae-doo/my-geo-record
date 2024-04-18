package site.jaedoo.mygeorecord.domain.service;

import site.jaedoo.mygeorecord.domain.dto.UserDataGroupInfo;

import java.util.List;

public interface DataGroupService {
    List<UserDataGroupInfo> findAllUsersDataGroup(Long userId);
}
