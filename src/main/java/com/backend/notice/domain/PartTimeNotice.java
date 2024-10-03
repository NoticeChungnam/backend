package com.backend.notice.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "part_time_notice")
@Entity
@Getter
public class PartTimeNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String title;
    private String status;

}
