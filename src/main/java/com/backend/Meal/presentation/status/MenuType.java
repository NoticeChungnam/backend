package com.backend.Meal.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum MenuType {

    MAIN_A("메인A"),
    MAIN_C("메인C"),
    OTHER("기타");


    private final String status;

    MenuType(String status) {
        this.status = status;
    }

    @JsonCreator
    public static MenuType from(String input) {
        return Stream.of(MenuType.values())
                .filter(menuType -> menuType.status.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid MealType: " + input));
    }

    @JsonValue
    public String getDescription() {
        return status;
    }

}
