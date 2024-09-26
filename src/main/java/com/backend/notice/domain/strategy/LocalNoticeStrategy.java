package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.LocalNoticeRepository;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalNoticeStrategy extends AbstractNoticeStrategy {

    private final LocalNoticeRepository jobNoticeRepository;

    @Override
    protected List<LocalNoticeResponse> fetchNotices() {
        return NoticeMapper.INSTANCE.toLocalNoticeResponses(jobNoticeRepository.findAll());
    }

}
