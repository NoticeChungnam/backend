package com.backend.notice.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Table(name = "activity_notice")
@Entity
@Getter
public class ActivityNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long num;
    private String title;
    private LocalDate date;

}
