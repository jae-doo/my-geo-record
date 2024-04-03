package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAllUser();
}
