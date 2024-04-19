package site.jaedoo.mygeorecord.web.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.domain.service.DataGroupService;
import site.jaedoo.mygeorecord.web.constant.SessionConst;

import java.util.List;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final DataGroupService dataGroupService;

    @GetMapping("/data-group")
    public ResponseEntity<List<DataGroupInfo>> findAllUsersDataGroupInfo(
            @SessionAttribute(SessionConst.USER) Long userId) {
        return ResponseEntity.ok(dataGroupService.searchUserDataGroups(userId));
    }
}
