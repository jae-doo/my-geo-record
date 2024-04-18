package site.jaedoo.mygeorecord.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.jaedoo.mygeorecord.web.exception.dto.ErrorCode;
import site.jaedoo.mygeorecord.web.exception.dto.ErrorResult;
import site.jaedoo.mygeorecord.web.exception.user.UserAuthenticationException;

@Slf4j
@RestControllerAdvice
public class ApiExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UserAuthenticationException.class)
    public ErrorResult handleUserAuthEx(UserAuthenticationException ex) {
        log.error("[exception handle]", ex);
        return new ErrorResult(ErrorCode.USER_NOT_AUTHORIZED, ex.getMessage());
    }
}
