package com.backend.meal.exception;

import com.backend.common.exception.BaseException;
import com.backend.common.exception.BaseExceptionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MealException extends BaseException {

    private final MealExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }

}
