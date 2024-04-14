package site.jaedoo.mygeorecord.web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.service.LoginService;
import site.jaedoo.mygeorecord.web.dto.LoginForm;
import site.jaedoo.mygeorecord.web.dto.LoginResponse;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginForm loginForm, HttpSession session) {
        Optional<User> optionalUser = loginService.login(loginForm.getEmail(), loginForm.getPassword());

        if (optionalUser.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(false));
        }

        session.setAttribute("id", optionalUser.get().getId());
        return ResponseEntity.ok(new LoginResponse(true));
    }
}
