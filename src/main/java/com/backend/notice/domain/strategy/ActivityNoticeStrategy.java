package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.ActivityNoticeRepository;
import com.backend.notice.domain.repository.PartTimeNoticeRepository;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.mapper.NoticeMapper;
import com.backend.notice.presentation.status.NoticeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityNoticeStrategy extends AbstractNoticeStrategy {

    private final ActivityNoticeRepository activityNoticeRepository;
    private final PartTimeNoticeRepository partTimeNoticeRepository;

    @Override
    protected List<NoticeResponse> fetchNotices(NoticeType noticeType) {
        List<NoticeResponse> activityNotices = NoticeMapper.INSTANCE.toActivityNoticeResponses(activityNoticeRepository.findAllByNoticeType(noticeType));
        List<NoticeResponse> partTimeNotices = NoticeMapper.INSTANCE.toPartTimeNoticeResponses(partTimeNoticeRepository.findAllByNoticeType(noticeType));

        activityNotices.addAll(partTimeNotices);
        return activityNotices;
    }

    @Override
    protected List<NoticeResponse> fetchAllNotices() {
        List<NoticeResponse> activityNotices = NoticeMapper.INSTANCE.toActivityNoticeResponses(activityNoticeRepository.findAll());
        List<NoticeResponse> partTimeNotices = NoticeMapper.INSTANCE.toPartTimeNoticeResponses(partTimeNoticeRepository.findAll());

        activityNotices.addAll(partTimeNotices);
        return activityNotices;
    }


}
