package com.backend.notice.domain.strategy;

import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;

import java.util.List;

public abstract class AbstractNoticeStrategy implements NoticeStrategy {

    @Override
    public final List<NoticeResponse> getNotices() {
        List<NoticeResponse> notices = fetchNotices();
        return validateAndReturn(notices);
    }

    @Override
    public final List<NoticeResponse> getAllNotices() {
        List<NoticeResponse> notices = fetchNotices();
        return validateAndReturn(notices);
    }

    protected abstract List<NoticeResponse> fetchNotices();

    protected <T> List<T> validateAndReturn(List<T> list) {
        if (list.isEmpty()) {
            throw new NoticeException(NoticeExceptionType.NOTICE_NOT_FOUND);
        }
        return list;
    }

}
