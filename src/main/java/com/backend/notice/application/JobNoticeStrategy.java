package com.backend.notice.application;

import com.backend.notice.domain.JobNotice;
import com.backend.notice.domain.repository.JobNoticeRepository;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobNoticeStrategy implements NoticeStrategy{

    private final JobNoticeRepository jobNoticeRepository;

    @Override
    public List<JobNoticeResponse> getNotices() {
        List<JobNotice> jobNotices = jobNoticeRepository.findAll();
        if(jobNotices.isEmpty()){
            throw new NoticeException(NoticeExceptionType.NOTICE_NOT_FOUND);
        }
        return NoticeMapper.INSTANCE.toJobNoticeResponses(jobNotices);
    }

}
