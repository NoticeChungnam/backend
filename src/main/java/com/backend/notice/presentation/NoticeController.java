package com.backend.notice.presentation;

import com.backend.common.response.CommonResponse;
import com.backend.notice.application.NoticeStrategyFactory;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.dto.NoticeResponseType;
import com.backend.notice.presentation.status.NoticeCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeStrategyFactory noticeStrategyFactory;

    @GetMapping("/{notice-category}")
    public CommonResponse<List<? extends NoticeResponseType>> getCommonNotice(
            @PathVariable("notice-category") final String noticeCategory) {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from(noticeCategory)), HttpStatus.OK, "공지사항 조회 성공");
    }

}
