package com.backend.notice.exception;

import com.backend.common.exception.BaseException;
import com.backend.common.exception.BaseExceptionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NoticeException extends BaseException {

    private final NoticeExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
