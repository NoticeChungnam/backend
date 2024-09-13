package com.backend.department.domain.repository;

import com.backend.department.domain.DepartmentNotice;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentNoticeRepository extends JpaRepository<DepartmentNotice, Long> {
    @EntityGraph(attributePaths = "articleDetails")
    List<DepartmentNotice> findByDepartmentName(String departmentName);
}
