package site.jaedoo.mygeorecord.web.controller.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    private int code;
    private String message;

    public ErrorResult(ErrorCode code, String message) {
        this.code = code.getCode();
        this.message = message;
    }
}
