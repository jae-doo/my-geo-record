package site.jaedoo.mygeorecord.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;

    public boolean checkAlreadyExist(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

    @Transactional
    public Optional<User> signUp(String email, String password) {
        if (checkAlreadyExist(email)) return Optional.empty();
        else return userRepository.createUser(email, password);
    }
}
