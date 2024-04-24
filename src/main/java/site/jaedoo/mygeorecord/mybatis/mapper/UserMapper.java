package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.jaedoo.mygeorecord.domain.entity.User;
import site.jaedoo.mygeorecord.mybatis.dto.user.UserRecord;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findUserByEmail(@Param("email") String email);
    int insertUser(UserRecord userDetails);
}
