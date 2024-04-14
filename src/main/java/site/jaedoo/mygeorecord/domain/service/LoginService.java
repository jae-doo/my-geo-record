package site.jaedoo.mygeorecord.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public Optional<User> login(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);

        return optionalUser.filter(u->u.getPassword().equals(password));
    }
}
