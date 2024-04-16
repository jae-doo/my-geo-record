package site.jaedoo.mygeorecord.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import site.jaedoo.mygeorecord.constant.SessionConst;
import site.jaedoo.mygeorecord.web.exception.UserAuthenticationException;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.USER) == null) {
            throw new UserAuthenticationException(request.getRequestURI() + " 접근 권한이 없습니다.");
        }
        return true;
    }
}
