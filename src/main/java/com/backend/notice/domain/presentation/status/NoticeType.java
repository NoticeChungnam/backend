package com.backend.notice.domain.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum NoticeType {

    OTHER("기타"),
    NATIONAL_WORK("국가근로"),
    GOVERNMENT_SUPPORT("정부지원"),
    BAEKMA_INTERNSHIP("백마인턴십"),
    OVERSEAS_INTERNSHIP("해외인턴십"),
    PROGRAM("프로그램"),
    NOTICE("공지사항");

    private final String description;

    NoticeType(String description) {
        this.description = description;
    }

    @JsonCreator
    public static NoticeType from(String input) {
        return Stream.of(NoticeType.values())
                .filter(noticeType -> noticeType.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid notice type: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

}