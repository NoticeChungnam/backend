package com.backend.notice.presentation;

import com.backend.common.response.CommonResponse;
import com.backend.notice.application.NoticeStrategyFactory;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.presentation.status.NoticeCategory;
import com.backend.notice.presentation.status.NoticeType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job-notice")
@RequiredArgsConstructor
public class JobNoticeController {

    private final NoticeStrategyFactory noticeStrategyFactory;

    @GetMapping("/all")
    public CommonResponse<List<NoticeResponse>> getJobNotice() {
        return CommonResponse.success(noticeStrategyFactory.getAllNotices(NoticeCategory.from("job")), HttpStatus.OK, "진로/취업/지역청년 공고 전체 조회 성공");
    }

    @GetMapping("/notice")
    public CommonResponse<List<NoticeResponse>> getNotice() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("job"), NoticeType.NOTICE), HttpStatus.OK, "진로/취업/지역청년 공지사항 조회 성공");
    }

    @GetMapping("/program")
    public CommonResponse<List<NoticeResponse>> getProgram() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("job"), NoticeType.PROGRAM), HttpStatus.OK, "진로/취업/지역청년 프로그램 조회 성공");
    }

    @GetMapping("/other")
    public CommonResponse<List<NoticeResponse>> getOther() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("job"), NoticeType.OTHER), HttpStatus.OK, "진로/취업/지역청년 기타 조회 성공");
    }

}
