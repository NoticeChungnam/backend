package com.backend.department.dto.response;

import java.util.List;

public record DepartmentNoticeResponse(String departmentName, Long boardNumber, List<ArticleDetailsResponse> articleDetails) {
}
