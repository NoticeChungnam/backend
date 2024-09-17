package com.backend.meal.service;

import com.backend.meal.domain.Meal;
import com.backend.meal.domain.repository.MealRepository;
import com.backend.meal.dto.MealResponse;
import com.backend.meal.mapper.MealMapper;
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
