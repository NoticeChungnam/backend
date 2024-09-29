package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.JobNoticeRepository;
import com.backend.notice.domain.repository.LocalNoticeRepository;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.mapper.NoticeMapper;
import com.backend.notice.presentation.status.NoticeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobNoticeStrategy extends AbstractNoticeStrategy {

    private final JobNoticeRepository jobNoticeRepository;
    private final LocalNoticeRepository localNoticeRepository;

    @Override
    protected List<NoticeResponse> fetchAllNotices() {
        List<NoticeResponse> jobNotices = NoticeMapper.INSTANCE.toJobNoticeResponses(jobNoticeRepository.findAll());
        List<NoticeResponse> localNotices = NoticeMapper.INSTANCE.toLocalNoticeResponses(localNoticeRepository.findAll());

        jobNotices.addAll(localNotices);
        return jobNotices;
    }

    @Override
    protected List<NoticeResponse> fetchNotices(NoticeType noticeType) {
        List<NoticeResponse> jobNotices = NoticeMapper.INSTANCE.toJobNoticeResponses(jobNoticeRepository.findAllByNoticeType(noticeType));
        List<NoticeResponse> localNotices = NoticeMapper.INSTANCE.toLocalNoticeResponses(localNoticeRepository.findAllByNoticeType(noticeType));

        jobNotices.addAll(localNotices);
        return jobNotices;
    }

}
