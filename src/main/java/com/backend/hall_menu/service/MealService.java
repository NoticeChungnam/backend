package com.backend.hall_menu.service;

import com.backend.hall_menu.domain.Meal;
import com.backend.hall_menu.domain.repository.MealRepository;
import com.backend.hall_menu.dto.MealResponse;
import com.backend.hall_menu.mapper.MealMapper;
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
