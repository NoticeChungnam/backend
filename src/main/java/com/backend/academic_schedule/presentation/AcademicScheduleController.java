package com.backend.academic_schedule.presentation;

import com.backend.academic_schedule.dto.response.AcademicScheduleResponse;
import com.backend.academic_schedule.presentation.status.Month;
import com.backend.academic_schedule.service.AcademicScheduleService;
import com.backend.common.response.CommonResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/academic-schedule")
public class AcademicScheduleController {
    private final AcademicScheduleService academicScheduleService;

    @GetMapping
    public CommonResponse<List<AcademicScheduleResponse>> getAcademicSchedule(
            @RequestParam("month") Month month
    ) {
        List<AcademicScheduleResponse> academicScheduleResponseList = academicScheduleService.getAcademicSchedule(month);
        return CommonResponse.success(academicScheduleResponseList, HttpStatus.OK, "학사 일정 정보를 불러오는데 성공하였습니다.");
    }
}
