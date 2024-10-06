package com.backend.hall_menu.exception;

import com.backend.common.exception.BaseExceptionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@RequiredArgsConstructor
public enum MealExceptionType implements BaseExceptionType {

    DESCRIPTION_NOT_FOUND(BAD_REQUEST, "존재하지 않는 학식 정보입니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }

}
