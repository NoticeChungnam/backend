package com.backend.notice.application;

import com.backend.notice.domain.LocalNotice;
import com.backend.notice.domain.repository.LocalNoticeRepository;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;
import com.backend.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalNoticeStrategy implements NoticeStrategy {

    private final LocalNoticeRepository jobNoticeRepository;

    @Override
    public List<LocalNoticeResponse> getNotices() {
        List<LocalNotice> localNotices = jobNoticeRepository.findAll();
        if(localNotices.isEmpty()){
            throw new NoticeException(NoticeExceptionType.NOTICE_NOT_FOUND);
        }
        return NoticeMapper.INSTANCE.toLocalNoticeResponses(localNotices);
    }

}
