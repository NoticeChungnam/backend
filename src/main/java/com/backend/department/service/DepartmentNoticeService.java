package com.backend.department.service;

import com.backend.department.domain.DepartmentNotice;
import com.backend.department.dto.DepartmentNoticeList;
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
        List<DepartmentNotice> departmentNotice = departmentNoticeRepository.findByDepartmentName(departmentName);
        DepartmentNoticeList departmentNoticeList = DepartmentNoticeList.createDepartmentNoticeList(departmentNotice);

        return departmentNoticeList.getDepartmentNoticeResponse();
    }
}
