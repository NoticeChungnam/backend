package com.backend.Meal.dto;

import com.backend.Meal.presentation.status.MenuType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record DormResponse(MenuType menuType, String menu) {
}
