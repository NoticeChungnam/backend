package com.backend.notice.application;

import com.backend.notice.dto.NoticeResponseType;

import java.util.List;

public interface NoticeStrategy {
    List<? extends NoticeResponseType> getNotices();
}
