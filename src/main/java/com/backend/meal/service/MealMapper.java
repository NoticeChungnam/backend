package com.backend.meal.service;

import com.backend.meal.domain.Meal;
import com.backend.meal.dto.MealResponse;
import com.backend.meal.dto.MealResponse.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MealMapper {

    private final ObjectMapper objectMapper;

    public MealResponse toMealResponse(Meal meal) {
        List<description> descriptions = parseDescription(meal.getDescription());
        return MealResponse.builder()
                .location(meal.getLocation())
                .mealType(meal.getMealType())
                .menuName(meal.getMenuName())
                .descriptions(descriptions)
                .price(meal.getPrice())
                .build();
    }

    private List<description> parseDescription(String descriptionJson) {
        if (descriptionJson == null || descriptionJson.isEmpty()) {
            return List.of();
        }
        try {
            List<String> descriptionList = objectMapper.readValue(descriptionJson, new TypeReference<List<String>>() {});
            return descriptionList.stream()
                    .map(description::new)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

}