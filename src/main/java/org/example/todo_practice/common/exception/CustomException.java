package org.example.todo_practice.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.todo_practice.enums.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }
}
