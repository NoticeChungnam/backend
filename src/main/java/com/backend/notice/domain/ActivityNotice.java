package com.backend.notice.domain;

import com.backend.notice.presentation.status.NoticeType;
import jakarta.persistence.*;

@Table(name = "activity_notice")
@Entity
public class ActivityNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long num;
    private String title;
    private String date;

}
