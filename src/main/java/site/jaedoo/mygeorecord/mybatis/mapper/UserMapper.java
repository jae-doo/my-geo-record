package site.jaedoo.mygeorecord.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.jaedoo.mygeorecord.domain.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUser();
}
