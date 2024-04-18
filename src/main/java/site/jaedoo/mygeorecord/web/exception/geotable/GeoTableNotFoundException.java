package site.jaedoo.mygeorecord.web.exception.geotable;

public class GeoTableNotFoundException extends RuntimeException {
    private static final String defaultMessage = "해당 지도가 존재하지 않습니다.";

    public GeoTableNotFoundException() {
        super(defaultMessage);
    }

    public GeoTableNotFoundException(String message) {
        super(message);
    }

    public GeoTableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeoTableNotFoundException(Throwable cause) {
        super(defaultMessage, cause);
    }
}
