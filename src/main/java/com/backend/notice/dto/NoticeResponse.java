package com.backend.notice.dto;

import com.backend.notice.presentation.status.NoticeType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NoticeResponse{

    @Builder
    @Getter
    public static class JobNoticeResponse implements NoticeResponseType {
        private Long id;
        private Long num;
        private NoticeType type;
        private String title;
        private String date;
    }

    @Builder
    @Getter
    public static class ActivityNoticeResponse implements NoticeResponseType {
        private Long id;
        private Long num;
        private String title;
        private String date;
    }

    @Builder
    @Getter
    public static class LocalNoticeResponse implements NoticeResponseType {
        private Long id;
        private Long num;
        private NoticeType type;
        private String title;
        private String date;
    }

    @Builder
    @Getter
    public static class OjtNoticeResponse implements NoticeResponseType {
        private Long id;
        private Long num;
        private NoticeType type;
        private String title;
        private String date;
    }

    @Builder
    @Getter
    public static class PartTimeNoticeResponse implements NoticeResponseType {
        private Long id;
        private String company;
        private String title;
        private String status;
    }

}
