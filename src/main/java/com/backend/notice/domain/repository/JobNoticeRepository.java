package com.backend.notice.domain.repository;

import com.backend.notice.domain.JobNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobNoticeRepository extends JpaRepository<JobNotice, Long>{
}
