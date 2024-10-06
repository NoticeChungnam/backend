package com.backend.Meal.mapper;

import com.backend.Meal.domain.Meal;
import com.backend.Meal.dto.MealResponse;
import com.backend.Meal.dto.MealResponse.*;
import com.backend.Meal.exception.MealException;
import com.backend.Meal.exception.MealExceptionType;
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
            return List.of(new description("운영 안함"));
        }
        try {
            List<String> descriptionList = objectMapper.readValue(descriptionJson, new TypeReference<List<String>>() {});
            return descriptionList.stream()
                    .map(description::new)
                    .toList();
        } catch (Exception e) {
            throw new MealException(MealExceptionType.DESCRIPTION_NOT_FOUND);
        }
    }

}