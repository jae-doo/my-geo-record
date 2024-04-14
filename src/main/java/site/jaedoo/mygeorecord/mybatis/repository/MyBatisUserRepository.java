package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.domain.repository.UserRepository;
import site.jaedoo.mygeorecord.mybatis.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
@RequiredArgsConstructor
public class MyBatisUserRepository implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }
}
