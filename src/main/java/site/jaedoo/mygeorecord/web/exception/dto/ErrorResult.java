package site.jaedoo.mygeorecord.web.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 에러가 발생했을 때의 응답을 정의합니다.
 */
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
