package com.backend.Meal.dto;

import com.backend.Meal.presentation.status.MealFor;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record HallResponse(MealFor mealFor, String hall2_Menu, String hall3_Menu, String hall4_Menu, String CheMenu) {
}

