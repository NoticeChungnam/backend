package com.backend.notice.application;

import com.backend.notice.domain.LocalNotice;
import com.backend.notice.domain.OjtNotice;
import com.backend.notice.domain.repository.OjtNoticeRepository;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OjtNoticeStrategy implements NoticeStrategy{

    private final OjtNoticeRepository ojtNoticeRepository;

    @Override
    public List<OjtNoticeResponse> getNotices() {
        List<OjtNotice> ojtNotices = ojtNoticeRepository.findAll();
        if(ojtNotices.isEmpty()){
            throw new NoticeException(NoticeExceptionType.NOTICE_NOT_FOUND);
        }
        return NoticeMapper.INSTANCE.toOjtNoticeResponses(ojtNotices);
    }

}

