package site.jaedoo.mygeorecord.web.exception.geotable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.jaedoo.mygeorecord.web.controller.geotable.MapController;
import site.jaedoo.mygeorecord.web.exception.dto.ErrorCode;
import site.jaedoo.mygeorecord.web.exception.dto.ErrorResult;

@Slf4j
@RestControllerAdvice(assignableTypes = {MapController.class})
public class GeoTableApiExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GeoTableLimitExceededException.class)
    public ErrorResult handleGeoTableLimitExceedEx(Exception ex) {
        log.error("[exception handle]", ex);
        return new ErrorResult(ErrorCode.MAP_LIMIT_EXCEEDED, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GeoTableNotFoundException.class)
    public ErrorResult handleGeoTableNotFoundEx(Exception ex) {
        log.error("[exception handle]", ex);
        return new ErrorResult(ErrorCode.MAP_NOT_FOUND, ex.getMessage());
    }
}
