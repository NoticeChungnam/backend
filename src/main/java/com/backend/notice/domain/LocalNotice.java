package com.backend.notice.domain;

import com.backend.notice.presentation.status.NoticeType;
import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "local_notice")
@Entity
@Getter
public class LocalNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long num;

    @Enumerated(EnumType.STRING)
    private NoticeType type;
    private String title;
    private String date;

}
