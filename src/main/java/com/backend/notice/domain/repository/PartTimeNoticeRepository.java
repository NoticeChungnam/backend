package com.backend.notice.domain.repository;

import com.backend.notice.domain.PartTimeNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartTimeNoticeRepository extends JpaRepository<PartTimeNotice, Long> {
}
