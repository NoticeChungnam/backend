package com.backend.notice.dto;

import com.backend.notice.presentation.status.NoticeType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record NoticeResponse(Long id, Long num, NoticeType type, String title, String date, String status, String company) {
}