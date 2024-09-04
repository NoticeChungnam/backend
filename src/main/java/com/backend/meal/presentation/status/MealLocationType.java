package com.backend.meal.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum MealLocationType {

    STUDENT_HALL_2("제2학생회관"),
    STUDENT_HALL_3("제3학생회관"),
    STUDENT_HALL_4("제4학생회관"),
    COLLEGE_OF_HUMAN_ECOLOGY("생활과학대학");

    private final String description;

    MealLocationType(String description) {
        this.description = description;
    }

    @JsonCreator
    public static MealLocationType from(String input) {
        return Stream.of(MealLocationType.values())
                .filter(locationType -> locationType.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid MealLocation: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}