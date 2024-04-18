package site.jaedoo.mygeorecord.web.exception.geotable;

public class GeoTableLimitExceededException extends RuntimeException {
    static private final String defaultMessageFormat = "지도 개수가 %d개를 초과했습니다.";

    public GeoTableLimitExceededException(int max) {
        super(String.format(defaultMessageFormat, max));
    }

    public GeoTableLimitExceededException(String message) {
        super(message);
    }

    public GeoTableLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeoTableLimitExceededException(int max, Throwable cause) {
        super(String.format(defaultMessageFormat, max), cause);
    }
}
