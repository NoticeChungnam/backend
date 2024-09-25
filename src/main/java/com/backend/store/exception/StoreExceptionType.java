package com.backend.store.exception;

import com.backend.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum StoreExceptionType implements BaseExceptionType {
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "조건에 맞는 음식점을 찾을 수 없습니다."),
    ;

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
