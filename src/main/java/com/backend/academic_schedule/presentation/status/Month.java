package com.backend.academic_schedule.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum Month {
    JANUARY("01월"),
    FEBRUARY("02월"),
    MARCH("03월"),
    APRIL("04월"),
    MAY("05월"),
    JUNE("06월"),
    JULY("07월"),
    AUGUST("08월"),
    SEPTEMBER("09월"),
    OCTOBER("10월"),
    NOVEMBER("11월"),
    DECEMBER("12월");

    private final String description;

    Month(String description) {
        this.description = description;
    }

    @JsonCreator
    public static Month from(String input) {
        return Stream.of(Month.values())
                .filter(month -> month.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid month: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    public static Month fromInt(int month) {
        return switch (month) {
            case 1 -> JANUARY;
            case 2 -> FEBRUARY;
            case 3 -> MARCH;
            case 4 -> APRIL;
            case 5 -> MAY;
            case 6 -> JUNE;
            case 7 -> JULY;
            case 8 -> AUGUST;
            case 9 -> SEPTEMBER;
            case 10 -> OCTOBER;
            case 11 -> NOVEMBER;
            case 12 -> DECEMBER;
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }
}
