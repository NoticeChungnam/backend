package com.backend.academic_schedule.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private final int description;

    Month(int description) {
        this.description = description;
    }

    @JsonCreator
    public static Month from(int input) {
        return Stream.of(Month.values())
                .filter(month -> month.description == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid month: " + input));
    }

    @JsonValue
    public int getDescription() {
        return description;
    }
}
