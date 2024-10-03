package com.backend.notice.domain.strategy;

import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;
import com.backend.notice.presentation.status.NoticeType;

import java.util.List;

public abstract class AbstractNoticeStrategy implements NoticeStrategy {

    @Override
    public final List<NoticeResponse> getNotices(NoticeType noticeType) {
        List<NoticeResponse> notices = fetchNotices(noticeType);
        return validateAndReturn(notices);
    }

    @Override
    public final List<NoticeResponse> getAllNotices() {
        List<NoticeResponse> notices = fetchAllNotices();
        return validateAndReturn(notices);
    }

    protected abstract List<NoticeResponse> fetchNotices(NoticeType noticeType);
    protected abstract List<NoticeResponse> fetchAllNotices();

    protected <T> List<T> validateAndReturn(List<T> list) {
        if (list.isEmpty()) {
            throw new NoticeException(NoticeExceptionType.NOTICE_NOT_FOUND);
        }
        return list;
    }

}
