package site.jaedoo.mygeorecord.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import site.jaedoo.mygeorecord.web.constant.SessionConst;
import site.jaedoo.mygeorecord.web.exception.user.UserAuthenticationException;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.USER) == null) {
            log.error("{}에서 {}로 인증되지 않은 접근을 시도했습니다.", request.getRemoteAddr(), request.getRequestURI());
            String message = String.format("%s 경로에 접근 권한이 없습니다.", request.getRequestURI());
            throw new UserAuthenticationException(message);
        }
        return true;
    }
}
