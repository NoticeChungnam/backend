package com.backend.department.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
@Table(name = "article_details")
public class ArticleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleDetailsId;

    private Long boardNumber;
    private String articleTitle;
    private String writerName;
    private String clickCount;
    private String attachCount;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "department_notice_id")
    private DepartmentNotice departmentNotice;
}
