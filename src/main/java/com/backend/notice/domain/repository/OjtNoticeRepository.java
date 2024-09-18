package com.backend.notice.domain.repository;

import com.backend.notice.domain.OjtNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OjtNoticeRepository extends JpaRepository<OjtNotice, Long>{
}
