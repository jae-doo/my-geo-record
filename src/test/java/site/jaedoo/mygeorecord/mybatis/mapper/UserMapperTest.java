package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.domain.entity.User;

import java.util.Optional;

@MybatisTest
class UserMapperTest {
    @Autowired UserMapper userMapper;

    @Test
    @DisplayName("사용자 생성 테스트")
    void createUser() {
        // given
        String email = "fosong98@gmail.com";
        String password = "1234";

        // when
        int result = userMapper.insertUser(email, password);

        // then
        Assertions.assertEquals(result, 1);

        Optional<User> optionalUser = userMapper.findUserByEmail(email);
        Assertions.assertTrue(optionalUser.isPresent());

        User user = optionalUser.get();
        Assertions.assertEquals(user.getPassword(), password);
    }
}