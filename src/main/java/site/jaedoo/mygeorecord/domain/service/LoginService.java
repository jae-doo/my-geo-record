package site.jaedoo.mygeorecord.domain.service;

import site.jaedoo.mygeorecord.domain.entity.User;

import java.util.Optional;

public interface LoginService {
    Optional<User> login(String email, String password);
}
