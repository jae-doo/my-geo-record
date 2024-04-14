package site.jaedoo.mygeorecord.domain.entity;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class User {
    private Long id;
    private String email;
    private String password;
}