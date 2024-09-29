package com.backend.notice.presentation;

import com.backend.common.response.CommonResponse;
import com.backend.notice.application.NoticeStrategyFactory;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.presentation.status.NoticeCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ojt-notice")
@RequiredArgsConstructor
public class OjtNoticeController {

    NoticeStrategyFactory noticeStrategyFactory;

    @GetMapping("/all")
    public CommonResponse<List<NoticeResponse>> getOjtNotice() {
        return CommonResponse.success(noticeStrategyFactory.getAllNotices(NoticeCategory.from("ojt")), HttpStatus.OK, "현장실습 공고 조회 성공");
    }
}
