package site.jaedoo.mygeorecord.web.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.service.SignUpService;
import site.jaedoo.mygeorecord.web.exception.user.DuplicateUserException;
import site.jaedoo.mygeorecord.web.controller.user.dto.SignUpForm;
import site.jaedoo.mygeorecord.web.controller.user.dto.SignUpResponse;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sign-up")
public class SignUpController {
    private final SignUpService signUpService;

    @GetMapping("/check")
    public ResponseEntity<?> checkEmail(@RequestParam String email) {
        boolean duplicated = signUpService.checkAlreadyExist(email);
        if (duplicated) throw new DuplicateUserException();
        else return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpForm signUpForm) {
        Optional<User> optionalUser = signUpService.signUp(signUpForm.getEmail(), signUpForm.getPassword());

        return optionalUser.map(SignUpResponse::new)
                .map(ResponseEntity::ok)
                .orElseThrow(DuplicateUserException::new);
    }
}
