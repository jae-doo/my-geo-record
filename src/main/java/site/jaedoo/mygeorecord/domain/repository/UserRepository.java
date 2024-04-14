package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAllUser();
    Optional<User> findUserByEmail(String email);
}
