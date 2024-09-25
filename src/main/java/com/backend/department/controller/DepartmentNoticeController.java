package com.backend.department.controller;

import com.backend.common.response.CommonResponse;
import com.backend.department.dto.response.DepartmentNoticeResponse;
import com.backend.department.service.DepartmentNoticeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments/notice")
@RequiredArgsConstructor
public class DepartmentNoticeController {
    private final DepartmentNoticeService departmentNoticeService;

    @GetMapping
    public CommonResponse<List<DepartmentNoticeResponse>> getDepartmentNotice(
            @RequestParam("department_name") String departmentName
    ) {
        List<DepartmentNoticeResponse> departmentNoticeResponse = departmentNoticeService.getDepartmentNotice(departmentName);
        return CommonResponse.success(departmentNoticeResponse, HttpStatus.OK, "학과 공지사항 조회에 성공하였습니다.");
    }
}
