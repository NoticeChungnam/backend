package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.OjtNoticeRepository;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OjtNoticeStrategy extends AbstractNoticeStrategy {

    private final OjtNoticeRepository ojtNoticeRepository;

    @Override
    protected List<OjtNoticeResponse> fetchNotices() {
        return NoticeMapper.INSTANCE.toOjtNoticeResponses(ojtNoticeRepository.findAll());
    }

}

