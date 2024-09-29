package com.backend.notice.presentation;

import com.backend.common.response.CommonResponse;
import com.backend.notice.application.NoticeStrategyFactory;
import com.backend.notice.dto.NoticeResponse;
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
    public CommonResponse<List<NoticeResponse>> getCommonNotice(
            @PathVariable("notice-category") final String noticeCategory) {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from(noticeCategory)), HttpStatus.OK, "공지사항 조회 성공");
    }

    @GetMapping("/job")
    public CommonResponse<List<NoticeResponse>> getJobNotice() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("job")), HttpStatus.OK, "진로/취업/지역청년 공고 조회 성공");
    }

    @GetMapping("/activity")
    public CommonResponse<List<NoticeResponse>> getActivityNotice() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("activity")), HttpStatus.OK, "대외활동/아르바이트 공고 조회 성공");
    }

    @GetMapping("/ojt")
    public CommonResponse<List<NoticeResponse>> getOjtNotice() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("ojt")), HttpStatus.OK, "현장실습 공고 조회 성공");
    }

}
