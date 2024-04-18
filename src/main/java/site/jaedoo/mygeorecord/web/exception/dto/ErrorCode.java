package site.jaedoo.mygeorecord.web.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API 에러 코드를 정의합니다.
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(101), USER_DUPLICATED(102), LOGIN_FAIL(103), USER_NOT_AUTHORIZED(104),
    MAP_NOT_FOUND(201), MAP_LIMIT_EXCEEDED(202);

    private final int code;
}
