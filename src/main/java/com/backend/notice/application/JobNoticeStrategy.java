package com.backend.notice.application;

import com.backend.notice.domain.JobNotice;
import com.backend.notice.domain.repository.JobNoticeRepository;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobNoticeStrategy extends AbstractNoticeStrategy {

    private final JobNoticeRepository jobNoticeRepository;

    @Override
    public List<JobNoticeResponse> fetchNotices() {
        return NoticeMapper.INSTANCE.toJobNoticeResponses(jobNoticeRepository.findAll());
    }

}
