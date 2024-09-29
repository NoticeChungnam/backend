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
@RequestMapping("/job-notice")
@RequiredArgsConstructor
public class JobNoticeController {

    private final NoticeStrategyFactory noticeStrategyFactory;

    @GetMapping("/all")
    public CommonResponse<List<NoticeResponse>> getJobNotice() {
        return CommonResponse.success(noticeStrategyFactory.getAllNotices(NoticeCategory.from("job")), HttpStatus.OK, "진로/취업/지역청년 공고 조회 성공");
    }

}
