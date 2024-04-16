package site.jaedoo.mygeorecord.domain.service;

import site.jaedoo.mygeorecord.domain.entity.User;

import java.util.Optional;

public interface SignUpService {
    boolean checkAlreadyExist(String email);
    Optional<User> signUp(String email, String password);
}
