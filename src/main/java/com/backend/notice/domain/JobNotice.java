package com.backend.notice.domain;

import com.backend.notice.domain.presentation.status.NoticeType;
import jakarta.persistence.*;

@Table(name = "job_notice")
@Entity
public class JobNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long num;

    @Enumerated(EnumType.STRING)
    private NoticeType type;
    private String title;
    private String date;

}
