package site.jaedoo.mygeorecord.web.controller.datagroup;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import site.jaedoo.mygeorecord.domain.dto.UserDataGroupInfo;
import site.jaedoo.mygeorecord.domain.repository.DataGroupRepository;
import site.jaedoo.mygeorecord.domain.service.DataGroupService;
import site.jaedoo.mygeorecord.web.constant.SessionConst;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/data-group")
public class DataGroupController {
    private final DataGroupService dataGroupService;

    @GetMapping
    public ResponseEntity<List<UserDataGroupInfo>> findAllUsersDataGroupInfo(
            @SessionAttribute(SessionConst.USER) Long userId) {
        return ResponseEntity.ok(dataGroupService.findAllUsersDataGroup(userId));
    }
}
