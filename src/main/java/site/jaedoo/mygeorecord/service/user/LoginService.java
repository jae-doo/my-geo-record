package site.jaedoo.mygeorecord.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public Optional<User> login(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        return optionalUser.filter(user->user.getPassword().equals(password));
    }
}
