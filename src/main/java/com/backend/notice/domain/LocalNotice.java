package com.backend.notice.domain;

import com.backend.notice.domain.presentation.status.NoticeType;
import jakarta.persistence.*;

@Table(name = "local_notice")
@Entity
public class LocalNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long num;
    private String type;
    private String title;
    private String date;

}
