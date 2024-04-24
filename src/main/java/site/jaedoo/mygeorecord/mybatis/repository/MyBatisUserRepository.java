package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.repository.UserRepository;
import site.jaedoo.mygeorecord.mybatis.dto.user.UserRecord;
import site.jaedoo.mygeorecord.mybatis.mapper.UserMapper;

import java.util.Optional;

@Repository("userRepository")
@RequiredArgsConstructor
public class MyBatisUserRepository implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    @Override
    public Optional<User> createUser(String email, String password) {
        if (findUserByEmail(email).isPresent()) return Optional.empty();

        UserRecord userDetails = new UserRecord(email, password);
        userMapper.insertUser(userDetails);

        return Optional.of(userDetails.convertUser());
    }
}
