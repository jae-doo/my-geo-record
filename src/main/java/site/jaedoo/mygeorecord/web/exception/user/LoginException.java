package site.jaedoo.mygeorecord.web.exception.user;

/**
 * 로그인을 실패했을 때 예외를 던집니다.
 */
public class LoginException extends RuntimeException {
    static final String defaultMessage = "로그인에 실패했습니다.";
    public LoginException() {
        super(defaultMessage);
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(defaultMessage, cause);
    }
}
