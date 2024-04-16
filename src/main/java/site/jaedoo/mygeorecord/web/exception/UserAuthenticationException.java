package site.jaedoo.mygeorecord.web.exception;

public class UserAuthenticationException extends RuntimeException {
    private static final String defaultMessage = "접근 권한이 없습니다.";
    public UserAuthenticationException() {
        super(defaultMessage);
    }

    public UserAuthenticationException(String message) {
        super(message);
    }

    public UserAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAuthenticationException(Throwable cause) {
        super(defaultMessage, cause);
    }
}
