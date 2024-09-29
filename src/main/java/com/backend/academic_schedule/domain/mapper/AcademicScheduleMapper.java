package com.backend.academic_schedule.domain.mapper;

import com.backend.academic_schedule.domain.AcademicSchedule;
import com.backend.academic_schedule.dto.response.AcademicScheduleResponse;

public class AcademicScheduleMapper {
    public static AcademicScheduleResponse toAcademicScheduleResponse(AcademicSchedule academicSchedule) {
        return new AcademicScheduleResponse(
                academicSchedule.getDateInfo(),
                academicSchedule.getSchedule()
        );
    }
}
