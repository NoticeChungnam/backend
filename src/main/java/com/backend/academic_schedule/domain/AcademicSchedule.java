package com.backend.academic_schedule.domain;

import com.backend.academic_schedule.presentation.status.Month;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "academic_schedule")
public class AcademicSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicScheduleId;
    private Long year;

    @Enumerated(EnumType.STRING)
    private Month month;

    private String dateInfo;
    private String schedule;
}
