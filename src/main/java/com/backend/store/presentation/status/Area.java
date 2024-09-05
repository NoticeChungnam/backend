package com.backend.store.presentation.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum Area {
    ALL("전체"),
    GOONG_DONG("궁동"),
    BONG_MYEONG_DONG("봉명동");

    private final String description;

    Area(String description) {
        this.description = description;
    }

    @JsonCreator
    public static Area from(String input) {
        return Stream.of(Area.values())
                .filter(area -> area.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid area: " + input));
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}
