package com.backend.notice.domain.strategy;

import com.backend.notice.domain.repository.PartTimeNoticeRepository;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.backend.notice.dto.NoticeResponse.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartTimeNoticeStrategy extends AbstractNoticeStrategy {

    private final PartTimeNoticeRepository partTimeNoticeRepository;

    @Override
    protected List<PartTimeNoticeResponse> fetchNotices() {
        return NoticeMapper.INSTANCE.toPartTimeNoticeResponses(partTimeNoticeRepository.findAll());
    }

}
