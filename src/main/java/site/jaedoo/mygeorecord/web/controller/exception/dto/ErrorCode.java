package site.jaedoo.mygeorecord.web.controller.exception.dto;

public enum ErrorCode {
    USER_NOT_FOUND(101),
    USER_DUPLICATED(102),
    LOGIN_FAIL(103);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
