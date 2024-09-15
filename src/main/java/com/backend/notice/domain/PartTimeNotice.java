package com.backend.notice.domain;

import jakarta.persistence.*;

@Table(name = "part_time_notice")
@Entity
public class PartTimeNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String title;
    private String date;

}
