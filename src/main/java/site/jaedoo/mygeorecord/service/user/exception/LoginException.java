package site.jaedoo.mygeorecord.service.user.exception;

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
