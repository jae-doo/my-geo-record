package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.Data;
import site.jaedoo.mygeorecord.domain.entity.User;

@Data
public class UserDetails {
    private Long id;
    private String email;
    private String password;

    public UserDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User convertUser() {
        return new User(this.id, this.email, this.password);
    }
}
