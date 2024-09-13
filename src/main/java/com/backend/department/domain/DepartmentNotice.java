package com.backend.department.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
@Table(name = "department_notice")
public class DepartmentNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentNoticeId;

    private String departmentName;
    private Long boardNumber;

    @OneToMany(mappedBy = "departmentNotice", fetch = FetchType.LAZY)
    private List<ArticleDetails> articleDetails = new ArrayList<>();
}
