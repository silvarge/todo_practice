package org.example.todo_practice.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.todo_practice.enums.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class ExceptionDto {
    private final HttpStatus httpCode;
    private final String code;
    private final String message;

    public static ExceptionDto of(ErrorCode errorCode) {
        return new ExceptionDto(errorCode.getHttpStatus(), errorCode.getCode(), errorCode.getMessage());
    }
}
