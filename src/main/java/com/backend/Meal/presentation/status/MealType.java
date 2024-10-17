package com.backend.Meal.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum MealType {

    BREAKFAST("조식"),
    LUNCH("중식"),
    DINNER("석식");

    private final String status;

    MealType(String status) {
        this.status = status;
    }

    @JsonCreator
    public static MealType from(String input) {
        return Stream.of(MealType.values())
                .filter(mealType -> mealType.status.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid MealType: " + input));
    }

    @JsonValue
    public String getDescription() {
        return status;
    }

}
