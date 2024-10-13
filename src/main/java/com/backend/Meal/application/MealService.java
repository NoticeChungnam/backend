package com.backend.Meal.application;

import com.backend.Meal.domain.repository.DormMenuRepository;
import com.backend.Meal.domain.repository.HallMenuRepository;
import com.backend.Meal.dto.DormResponse;
import com.backend.Meal.dto.HallResponse;
import com.backend.Meal.presentation.status.MealType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final HallMenuRepository hallMenuRepository;
    private final DormMenuRepository dormMenuRepository;

    public List<HallResponse> getHallMenu(LocalDate date, MealType mealType) {
        return hallMenuRepository.findHallMenuDtoByDateAndMealType(date, mealType);
    }

    public List<DormResponse> getDormMenu(LocalDate date, MealType mealType) {
        return dormMenuRepository.findDormMenuDtoByDateAndMealType(date, mealType);
    }

}
