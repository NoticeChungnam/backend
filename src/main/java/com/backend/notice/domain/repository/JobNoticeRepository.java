package com.backend.notice.domain.repository;

import com.backend.notice.domain.JobNotice;
import com.backend.notice.presentation.status.NoticeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobNoticeRepository extends JpaRepository<JobNotice, Long>{

    List<JobNotice> findAllByNoticeType(NoticeType noticeType);
}
