package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.JobNoticeRepository;
//import com.backend.notice.domain.repository.LocalNoticeRepository;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.mapper.NoticeMapper;
import com.backend.notice.presentation.status.NoticeCategory;
import com.backend.notice.presentation.status.NoticeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobNoticeStrategy extends AbstractNoticeStrategy {

    private final JobNoticeRepository jobNoticeRepository;

    @Override
    public NoticeCategory getSupportedCategory() {
        return NoticeCategory.JOB;
    }

    @Override
    protected List<NoticeResponse> fetchAllNotices() {
        return NoticeMapper.INSTANCE.toJobNoticeResponses(jobNoticeRepository.findAllByOrderByDateDesc());
    }

    @Override
    protected List<NoticeResponse> fetchNotices(NoticeType noticeType) {
        return NoticeMapper.INSTANCE.toJobNoticeResponses(jobNoticeRepository.findAllByTypeOrderByDateDesc(noticeType));
    }

}
