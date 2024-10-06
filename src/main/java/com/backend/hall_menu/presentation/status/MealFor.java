package com.backend.hall_menu.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum MealFor {

    STUDENT("학생"),
    STAFF("직원");

    private final String status;

    MealFor(String status) {
        this.status = status;
    }

    @JsonCreator
    public static MealFor from(String input) {
        return Stream.of(MealFor.values())
                .filter(mealFor -> mealFor.status.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid MealType: " + input));
    }

    @JsonValue
    public String getDescription() {
        return status;
    }

}
