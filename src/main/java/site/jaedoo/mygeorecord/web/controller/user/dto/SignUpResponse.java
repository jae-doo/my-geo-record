package site.jaedoo.mygeorecord.web.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.jaedoo.mygeorecord.domain.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponse {
    private Long id;
    private String email;

    public SignUpResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }
}
