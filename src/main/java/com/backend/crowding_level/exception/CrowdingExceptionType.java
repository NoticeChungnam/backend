package com.backend.crowding_level.exception;

import com.backend.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CrowdingExceptionType implements BaseExceptionType {

    CROWDING_NOT_FOUND(HttpStatus.NOT_FOUND, "혼잡도를 조회할 수 없습니다."),
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
