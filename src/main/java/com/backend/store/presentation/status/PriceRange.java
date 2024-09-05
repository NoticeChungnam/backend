package com.backend.store.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum PriceRange {

    FIVE_TO_TEN("5000~10000"),
    TEN_TO_FIFTEEN("10000~15000"),
    FIFTEEN_TO_TWENTY("15000~20000"),
    TWENTY_TO_TWENTY_FIVE("20000~25000"),
    TWENTY_FIVE_TO_THIRTY("25000~30000"),
    THIRTY_AND_ABOVE("30000 이상");

    private final String description;

    PriceRange(String description) {
        this.description = description;
    }

    @JsonCreator
    public static PriceRange from(String input) {
        return Stream.of(PriceRange.values())
                .filter(priceRange -> priceRange.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid range: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

}
