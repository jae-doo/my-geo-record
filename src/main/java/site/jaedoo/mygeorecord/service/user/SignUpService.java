package site.jaedoo.mygeorecord.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.repository.UserRepository;

import java.util.Optional;

/**
 * 사용자의 회원가입을 처리합니다.
 */
@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;

    /**
     * 사용자의 이메일을 받아서 이미 회원으로 등록되어 있는지 확인합니다.
     * @param email 서비스 상 유일한 이메일입니다.
     * @return 사용자가 이미 존재하면 true, 사용자가 없으면 false를 리턴
     */
    public boolean checkAlreadyExist(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

    /**
     * 이메일과 비밀번호를 받아서 사용자를 등록합니다. 이메일은 서비스 상 유일해야 합니다.
     * 이메일이 중복되거나 사용자 생성에 실패한 경우, 빈 Optional을 리턴합니다.
     * 등록에 성공하면 해당 User를 Optional에 담아 리턴합니다.
     * @param email 서비스 상 유일해야 합니다.
     * @param password 사용자를 검증할 때 사용하는 비밀번호입니다.
     * @return 이메일이 중복되거나 사용자 생성에 실패하면 빈 Optional,
     * 등록에 성공하면 해당 User를 Optional에 담아 리턴
     */
    @Transactional
    public Optional<User> signUp(String email, String password) {
        if (checkAlreadyExist(email)) return Optional.empty();
        else return userRepository.createUser(email, password);
    }
}
