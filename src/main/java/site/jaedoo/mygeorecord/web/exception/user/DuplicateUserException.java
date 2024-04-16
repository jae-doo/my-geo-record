package site.jaedoo.mygeorecord.web.exception.user;

/**
 * 시스템 내에 식별 가능한 사용자가 이미 등록되어 있을 때 예외를 던집니다.
 */
public class DuplicateUserException extends RuntimeException {
    static final String defaultMessage = "사용자가 중복되었습니다.";
    public DuplicateUserException() {
        super(defaultMessage);
    }

    public DuplicateUserException(String message) {
        super(message);
    }

    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUserException(Throwable cause) {
        super(defaultMessage, cause);
    }
}
