package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.jaedoo.mygeorecord.domain.entity.User;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<User> findAllUser();
    Optional<User> findUserByEmail(@Param("email") String email);
}
