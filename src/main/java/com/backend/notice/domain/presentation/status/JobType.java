package com.backend.notice.domain.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum JobType {

    PROGRAM("프로그램"),
    NOTICE("공지사항"),
    OTHER("기타");

    private final String description;

    JobType(String description) {
        this.description = description;
    }

    @JsonCreator
    public static JobType from(String input) {
        return Stream.of(JobType.values())
                .filter(jobType -> jobType.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid job notice type: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}