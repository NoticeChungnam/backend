package com.backend.department.domain.mapper;

import com.backend.department.domain.ArticleDetails;
import com.backend.department.domain.DepartmentNotice;
import com.backend.department.dto.response.ArticleDetailsResponse;
import com.backend.department.dto.response.DepartmentNoticeResponse;
import java.util.List;

public class DepartmentMapper {
    public static DepartmentNoticeResponse toDepartmentNoticeResponse(DepartmentNotice departmentNotice) {
        return new DepartmentNoticeResponse(
                departmentNotice.getDepartmentName(),
                departmentNotice.getBoardNumber(),
                toArticleDetailsResponse(departmentNotice.getArticleDetails())
        );
    }

    public static List<ArticleDetailsResponse> toArticleDetailsResponse(List<ArticleDetails> articleDetails) {
        return articleDetails.stream()
                .map(articleDetail -> new ArticleDetailsResponse(
                        articleDetail.getArticleTitle(),
                        articleDetail.getUpdatedAt(),
                        articleDetail.getWriterName()
                ))
                .toList();
    }
}
