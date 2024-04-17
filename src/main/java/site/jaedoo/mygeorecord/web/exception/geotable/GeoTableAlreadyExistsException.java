package site.jaedoo.mygeorecord.web.exception.geotable;

public class GeoTableAlreadyExistsException extends RuntimeException {
    private static final String defaultMessage = "이미 존재하는 지도입니다.";
    public GeoTableAlreadyExistsException() {
        super(defaultMessage);
    }

    public GeoTableAlreadyExistsException(String message) {
        super(message);
    }

    public GeoTableAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeoTableAlreadyExistsException(Throwable cause) {
        super(defaultMessage, cause);
    }
}
