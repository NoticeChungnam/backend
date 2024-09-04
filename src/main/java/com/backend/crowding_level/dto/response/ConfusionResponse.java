package com.backend.crowding_level.dto.response;

import com.backend.crowding_level.presentation.status.LocationType;

public record ConfusionResponse(LocationType locationType, Long peopleCount) {
}
