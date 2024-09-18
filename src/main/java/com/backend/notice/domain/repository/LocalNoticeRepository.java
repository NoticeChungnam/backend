package com.backend.notice.domain.repository;

import com.backend.notice.domain.LocalNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalNoticeRepository extends JpaRepository<LocalNotice, Long>{
}
