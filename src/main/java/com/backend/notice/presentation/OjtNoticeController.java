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
@RequestMapping("/ojt-notice")
@RequiredArgsConstructor
public class OjtNoticeController {

    NoticeStrategyFactory noticeStrategyFactory;

    @GetMapping("/all")
    public CommonResponse<List<NoticeResponse>> getOjtNotice() {
        return CommonResponse.success(noticeStrategyFactory.getAllNotices(NoticeCategory.from("ojt")), HttpStatus.OK, "현장실습 전체 조회 성공");
    }

    @GetMapping("/baekma")
    public CommonResponse<List<NoticeResponse>> getBaekma() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("ojt"), NoticeType.BAEKMA_INTERNSHIP), HttpStatus.OK, "백마인턴십 조회 성공");
    }

    @GetMapping("/overseas")
    public CommonResponse<List<NoticeResponse>> getOverseas() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("ojt"), NoticeType.OVERSEAS_INTERNSHIP), HttpStatus.OK, "해외인턴십 조회 성공");
    }

    @GetMapping("/national")
    public CommonResponse<List<NoticeResponse>> getNational() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("ojt"), NoticeType.NATIONAL_WORK), HttpStatus.OK, "국가근로 조회 성공");
    }

    @GetMapping("/government")
    public CommonResponse<List<NoticeResponse>> getGovernment() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("ojt"), NoticeType.GOVERNMENT_SUPPORT), HttpStatus.OK, "정부지원 조회 성공");
    }

    @GetMapping("/other")
    public CommonResponse<List<NoticeResponse>> getOther() {
        return CommonResponse.success(noticeStrategyFactory.getNotices(NoticeCategory.from("ojt"), NoticeType.OTHER), HttpStatus.OK, "기타 조회 성공");
    }

}
