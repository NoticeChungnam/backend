package com.backend.notice.dto;

import com.backend.notice.presentation.status.NoticeType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NoticeResponse {

    public record JobNoticeResponse(Long id, Long num, NoticeType type, String title, String date) implements NoticeResponseType {
    }

    public record ActivityNoticeResponse(Long id, Long num, String title, String date) implements NoticeResponseType {
    }

    public record LocalNoticeResponse(Long id, Long num, NoticeType type, String title, String date) implements NoticeResponseType {
    }

    public record OjtNoticeResponse(Long id, Long num, NoticeType type, String title, String date) implements NoticeResponseType {
    }

    public record PartTimeNoticeResponse(Long id, String company, String title, String status) implements NoticeResponseType {
    }

}