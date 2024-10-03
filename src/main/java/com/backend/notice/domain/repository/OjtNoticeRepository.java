package com.backend.notice.domain.repository;

import com.backend.notice.domain.OjtNotice;
import com.backend.notice.presentation.status.NoticeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OjtNoticeRepository extends JpaRepository<OjtNotice, Long>{
    List<OjtNotice> findAllByTypeOrderByDateDesc(NoticeType noticeType);
}
