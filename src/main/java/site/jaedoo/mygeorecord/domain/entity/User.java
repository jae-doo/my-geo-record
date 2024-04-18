package site.jaedoo.mygeorecord.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
}