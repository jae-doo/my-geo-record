package site.jaedoo.mygeorecord.web.exception.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.jaedoo.mygeorecord.web.controller.user.LoginController;
import site.jaedoo.mygeorecord.web.controller.user.SignUpController;
import site.jaedoo.mygeorecord.web.exception.geotable.GeoTableLimitExceededException;
import site.jaedoo.mygeorecord.web.exception.user.UserAuthenticationException;
import site.jaedoo.mygeorecord.web.exception.user.DuplicateUserException;
import site.jaedoo.mygeorecord.web.exception.user.LoginException;
import site.jaedoo.mygeorecord.web.exception.dto.ErrorCode;
import site.jaedoo.mygeorecord.web.exception.dto.ErrorResult;

@Slf4j
@RestControllerAdvice(assignableTypes = {LoginController.class, SignUpController.class})
public class UserApiExceptionControllerAdvice {
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
