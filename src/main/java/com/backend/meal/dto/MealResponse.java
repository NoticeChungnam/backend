package com.backend.meal.dto;

import com.backend.meal.presentation.status.MealType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse {

    private String location;
    private MealType mealType;
    private String menuName;
    private List<description> descriptions;
    private Long price;

    public record description(String description) {
    }

}
