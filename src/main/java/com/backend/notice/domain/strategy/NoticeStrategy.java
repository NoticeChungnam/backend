package com.backend.notice.domain.strategy;

import com.backend.notice.dto.NoticeResponse;

import java.util.List;

public interface NoticeStrategy {

    List<NoticeResponse> getNotices();
    List<NoticeResponse> getAllNotices();

}
