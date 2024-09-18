package com.backend.notice.application;

import com.backend.notice.domain.PartTimeNotice;
import com.backend.notice.domain.repository.PartTimeNoticeRepository;
import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.backend.notice.dto.NoticeResponse.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartTimeNoticeStrategy implements NoticeStrategy {

    private final PartTimeNoticeRepository partTimeNoticeRepository;

    @Override
    public List<PartTimeNoticeResponse> getNotices() {
        List< PartTimeNotice> partTimeNotices = partTimeNoticeRepository.findAll();
        if(partTimeNotices.isEmpty()){
            throw new NoticeException(NoticeExceptionType.NOTICE_NOT_FOUND);
        }
        return NoticeMapper.INSTANCE.toPartTimeNoticeResponses(partTimeNotices);
    }
}
