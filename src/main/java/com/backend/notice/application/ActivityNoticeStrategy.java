package com.backend.notice.application;

import com.backend.notice.domain.ActivityNotice;
import com.backend.notice.domain.repository.ActivityNoticeRepository;
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
    public List<ActivityNoticeResponse> getNotices() {
        List<ActivityNotice> activityNotices = activityNoticeRepository.findAll();
        return validateAndReturn(NoticeMapper.INSTANCE.toActivityNoticeResponses(activityNotices));
    }

}
