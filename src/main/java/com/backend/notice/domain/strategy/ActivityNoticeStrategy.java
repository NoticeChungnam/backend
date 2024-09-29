package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.ActivityNoticeRepository;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityNoticeStrategy extends AbstractNoticeStrategy {

    private final ActivityNoticeRepository activityNoticeRepository;

    @Override
    protected List<NoticeResponse> fetchNotices() {
        return NoticeMapper.INSTANCE.toActivityNoticeResponses(activityNoticeRepository.findAll());
    }

}
