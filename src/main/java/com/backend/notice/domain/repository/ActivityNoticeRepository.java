package com.backend.notice.domain.repository;

import com.backend.notice.domain.ActivityNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityNoticeRepository extends JpaRepository<ActivityNotice, Long>{

}
