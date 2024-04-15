package site.jaedoo.mygeorecord.service.user.exception;

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
