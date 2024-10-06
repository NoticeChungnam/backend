package com.backend.Meal.service;

import com.backend.Meal.domain.Meal;
import com.backend.Meal.domain.repository.MealRepository;
import com.backend.Meal.dto.MealResponse;
import com.backend.Meal.mapper.MealMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final MealMapper mealMapper;

    public List<MealResponse> getMeal() {
        List<Meal> meals = mealRepository.findAll();
        return meals.stream()
                .map(mealMapper::toMealResponse)
                .toList();
    }

}
