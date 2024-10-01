package com.backend.academic_schedule.domain.repository;

import com.backend.academic_schedule.domain.AcademicSchedule;
import com.backend.academic_schedule.presentation.status.Month;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicScheduleRepository extends JpaRepository<AcademicSchedule, Long> {
    List<AcademicSchedule> findAllByMonth(Month month);
}
