package com.backend.store.exception;

import com.backend.common.exception.BaseException;
import com.backend.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StoreException extends BaseException {
    private final StoreExceptionType storeExceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return storeExceptionType;
    }
}
