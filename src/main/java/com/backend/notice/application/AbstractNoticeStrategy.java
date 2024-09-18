package com.backend.notice.application;

import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;

import java.util.List;

public abstract class AbstractNoticeStrategy implements NoticeStrategy {

    protected <T> List<T> validateAndReturn(List<T> list) {
        if (list.isEmpty()) {
            throw new NoticeException(NoticeExceptionType.NOTICE_NOT_FOUND);
        }
        return list;
    }

}
