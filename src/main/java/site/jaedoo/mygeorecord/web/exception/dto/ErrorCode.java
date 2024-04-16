package site.jaedoo.mygeorecord.web.exception.dto;

/**
 * API 에러 코드를 정의합니다.
 */
public enum ErrorCode {
    USER_NOT_FOUND(101),
    USER_DUPLICATED(102),
    LOGIN_FAIL(103),
    USER_NOT_AUTHORIZED(104);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}