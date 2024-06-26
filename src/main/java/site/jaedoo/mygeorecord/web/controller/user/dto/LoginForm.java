package site.jaedoo.mygeorecord.web.controller.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
