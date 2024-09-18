package com.backend.notice.presentation.status;

import com.backend.notice.exception.NoticeException;
import com.backend.notice.exception.NoticeExceptionType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum NoticeCategory {

    JOB("job"),
    LOCAL("local"),
    OJT("ojt"),
    ACTIVITY("activity"),
    PARTTIME("part-time"),;

    private final String description;

    NoticeCategory(String description) {
        this.description = description;
    }

    @JsonCreator
    public static NoticeCategory from(String input) {
        return Stream.of(NoticeCategory.values())
                .filter(noticeCategory -> noticeCategory.description.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new NoticeException(NoticeExceptionType.CATEGORY_NOT_FOUND));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

}
