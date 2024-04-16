package site.jaedoo.mygeorecord.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import site.jaedoo.mygeorecord.domain.entity.User;

@Data
@AllArgsConstructor
public class LoginResponse {
    private Long id;

    public LoginResponse(User user) {
        this.id = user.getId();
    }
}
