package com.backend.academic_schedule.service;

import com.backend.academic_schedule.domain.mapper.AcademicScheduleMapper;
import com.backend.academic_schedule.domain.repository.AcademicScheduleRepository;
import com.backend.academic_schedule.dto.response.AcademicScheduleResponse;
import com.backend.academic_schedule.presentation.status.Month;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AcademicScheduleService {
    private final AcademicScheduleRepository academicScheduleRepository;

    @Transactional(readOnly = true)
    public List<AcademicScheduleResponse> getAcademicSchedule(int month) {
        Month monthEnum = Month.fromInt(month);
        return academicScheduleRepository.findAllByMonth(monthEnum).stream()
                .map(AcademicScheduleMapper::toAcademicScheduleResponse)
                .toList();
    }
}
