package com.backend.notice.domain.repository;

import com.backend.notice.domain.LocalNotice;
import com.backend.notice.presentation.status.NoticeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalNoticeRepository extends JpaRepository<LocalNotice, Long>{
    List<LocalNotice> findAllByNoticeType(NoticeType noticeType);
}
