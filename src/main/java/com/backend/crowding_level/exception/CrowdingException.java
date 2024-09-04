package com.backend.crowding_level.exception;

import com.backend.common.exception.BaseException;
import com.backend.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrowdingException extends BaseException {

    private final BaseExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }

}
