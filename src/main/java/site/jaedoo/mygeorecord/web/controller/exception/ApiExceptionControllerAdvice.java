package site.jaedoo.mygeorecord.web.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.jaedoo.mygeorecord.service.user.exception.DuplicateUserException;
import site.jaedoo.mygeorecord.service.user.exception.LoginException;
import site.jaedoo.mygeorecord.web.controller.exception.dto.ErrorCode;
import site.jaedoo.mygeorecord.web.controller.exception.dto.ErrorResult;

@Slf4j
@RestControllerAdvice
public class ApiExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateUserException.class)
    public ErrorResult handleDuplicateUser(DuplicateUserException ex) {
        log.error("[exception handle]", ex);
        return new ErrorResult(ErrorCode.USER_DUPLICATED, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LoginException.class)
    public ErrorResult handleLoginFail(LoginException ex) {
        log.error("[exception handle]", ex);
        return new ErrorResult(ErrorCode.LOGIN_FAIL, ex.getMessage());
    }
}
