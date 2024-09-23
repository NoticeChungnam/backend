package com.backend.department.service;

import com.backend.department.domain.DepartmentNotice;
import com.backend.department.domain.mapper.DepartmentMapper;
import com.backend.department.dto.response.DepartmentNoticeResponse;
import com.backend.department.domain.repository.DepartmentNoticeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentNoticeService {
    private final DepartmentNoticeRepository departmentNoticeRepository;

    public List<DepartmentNoticeResponse> getDepartmentNotice(String departmentName) {
        List<DepartmentNotice> departmentNotices = departmentNoticeRepository.findByDepartmentName(departmentName);

        return departmentNotices.stream()
                .map(DepartmentMapper::toDepartmentNoticeResponse)
                .toList();
    }
}
