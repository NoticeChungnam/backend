package com.backend.notice.presentation;

import com.backend.common.response.CommonResponse;
import com.backend.notice.application.NoticeStrategyFactory;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.presentation.status.NoticeCategory;
import com.backend.notice.presentation.status.NoticeType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity-notice")
@RequiredArgsConstructor
public class ActivityNoticeController {

    private final NoticeStrategyFactory noticeStrategyFactory;

    @GetMapping("/all")
    public CommonResponse<List<NoticeResponse>> getActivityNotice() {
        return CommonResponse.success(noticeStrategyFactory.getAllNotices(NoticeCategory.ACTIVITY), HttpStatus.OK, "대외활동/아르바이트 전체 조회 성공");
    }

    @GetMapping("/activity")
    public CommonResponse<List<NoticeResponse>> getActivity() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.ACTIVITY, NoticeType.ACTIVITY), HttpStatus.OK, "대외활동 조회 성공");
    }

    @GetMapping("/part-time")
    public CommonResponse<List<NoticeResponse>> getPartTime() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.ACTIVITY, NoticeType.PART_TIME), HttpStatus.OK, "아르바이트 조회 성공");
    }

}
