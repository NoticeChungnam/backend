package com.backend.crowding_level.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum LocationType {

    LIBRARY_BOTTOM_FLOOR_2("중앙도서관 B2F"),
    LIBRARY_BOTTOM_FLOOR_1("중앙도서관 B1F"),
    LIBRARY_FLOOR_1("중앙도서관 1F"),
    LIBRARY_FLOOR_2("중앙도서관 2F"),
    LIBRARY_FLOOR_3("중앙도서관 3F"),
    STUDENT_HALL_1("제1학생회관"),
    STUDENT_HALL_2("제2학생회관");

    private final String description;

    LocationType(String description) {
        this.description = description;
    }

    @JsonCreator
    public static LocationType from(String input) {
        return Stream.of(LocationType.values())
                .filter(locationType -> locationType.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid location: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}