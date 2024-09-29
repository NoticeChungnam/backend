package com.backend.notice.domain.strategy;

import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.presentation.status.NoticeType;

import java.util.List;

public interface NoticeStrategy {

    List<NoticeResponse> getNotices(NoticeType noticeType);
    List<NoticeResponse> getAllNotices();

}
