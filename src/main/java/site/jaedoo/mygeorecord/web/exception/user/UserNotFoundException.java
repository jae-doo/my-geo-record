package site.jaedoo.mygeorecord.web.exception.user;

/**
 * 사용자가 있어야 하나, 존재하지 않을 때 예외를 던집니다.
 */
public class UserNotFoundException extends RuntimeException {
    static final String defaultMessage = "사용자가 존재하지 않습니다.";

    public UserNotFoundException() {
        super(defaultMessage);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(defaultMessage, cause);
    }
}
