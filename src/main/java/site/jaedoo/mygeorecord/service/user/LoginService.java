package site.jaedoo.mygeorecord.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.repository.UserRepository;

import java.util.Optional;

/**
 * 사용자의 로그인을 처리합니다.
 */
@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    /**
     * 사용자의 이메일과 비밀번호를 받아서 저장된 정보와 일치할 경우,
     * 사용자의 객체를 담은 Optional 객체를 리턴합니다.
     * @param email 사용자를 식별할 수 있는 이메일입니다.
     * @param password 로그인 접속을 검증하기 위한 비밀번호입니다.
     * @return email에 해당하는 사용자가 존재하지 않거나 비밀번호가 일치하지 않으면 빈 Optional,
     * email에 해당하는 사용자가 존재하고 비밀번호가 일치하면 해당 사용자 객체를 담은 Optional을 리턴
     */
    public Optional<User> login(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        return optionalUser.filter(user->user.getPassword().equals(password));
    }
}
