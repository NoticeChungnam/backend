package com.backend.department.dto;

import com.backend.department.domain.ArticleDetails;
import com.backend.department.domain.DepartmentNotice;
import com.backend.department.dto.response.ArticleDetailsResponse;
import com.backend.department.dto.response.DepartmentNoticeResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DepartmentNoticeList {
    private final List<DepartmentNotice> departmentNotices;

    private DepartmentNoticeList(List<DepartmentNotice> departmentNotices) {
        this.departmentNotices = new ArrayList<>(departmentNotices);
    }

    public static DepartmentNoticeList createDepartmentNoticeList(List<DepartmentNotice> departmentNotices) {
        return new DepartmentNoticeList(departmentNotices);
    }

    private DepartmentNoticeResponse toDepartmentNoticeResponse(DepartmentNotice departmentNotice) {
        return new DepartmentNoticeResponse(
                departmentNotice.getDepartmentName(),
                departmentNotice.getBoardNumber(),
                toArticleDetailsResponse(departmentNotice.getArticleDetails())
        );
    }

    private List<ArticleDetailsResponse> toArticleDetailsResponse(List<ArticleDetails> articleDetails) {
        return articleDetails.stream()
                .map(articleDetail -> new ArticleDetailsResponse(
                        articleDetail.getArticleTitle(),
                        articleDetail.getUpdatedAt(),
                        articleDetail.getWriterName()
                ))
                .toList();
    }

    public List<DepartmentNoticeResponse> getDepartmentNoticeResponse() {
        return departmentNotices.stream()
                .map(this::toDepartmentNoticeResponse)
                .toList();
    }
}
