package com.backend.store.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum CategoryMajor {
    ALL("전체"),
    RESTAURANT("음식점"),
    CAFE("카페"),
    PUB("술집");

    private final String description;

    CategoryMajor(String description) {
        this.description = description;
    }

    @JsonCreator
    public static CategoryMajor from(String input) {
        return Stream.of(CategoryMajor.values())
                .filter(category -> category.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid category: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}
