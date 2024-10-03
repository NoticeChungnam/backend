package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.OjtNoticeRepository;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.mapper.NoticeMapper;
import com.backend.notice.presentation.status.NoticeCategory;
import com.backend.notice.presentation.status.NoticeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OjtNoticeStrategy extends AbstractNoticeStrategy {

    private final OjtNoticeRepository ojtNoticeRepository;

    @Override
    public NoticeCategory getSupportedCategory() {
        return NoticeCategory.OJT;
    }

    @Override
    protected List<NoticeResponse> fetchNotices(NoticeType noticeType) {
        return NoticeMapper.INSTANCE.toOjtNoticeResponses(ojtNoticeRepository.findAllByTypeOrderByDateDesc(noticeType));
    }

    @Override
    protected List<NoticeResponse> fetchAllNotices() {
        return NoticeMapper.INSTANCE.toOjtNoticeResponses(ojtNoticeRepository.findAll());
    }

}

