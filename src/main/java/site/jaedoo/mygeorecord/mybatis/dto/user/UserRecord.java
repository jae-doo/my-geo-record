package site.jaedoo.mygeorecord.mybatis.dto.user;

import lombok.Data;
import site.jaedoo.mygeorecord.domain.entity.User;

@Data
public class UserRecord {
    private Long id;
    private String email;
    private String password;

    public UserRecord(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User convertUser() {
        return new User(this.id, this.email, this.password);
    }
}
