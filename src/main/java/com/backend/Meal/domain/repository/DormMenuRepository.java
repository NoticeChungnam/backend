package com.backend.Meal.domain.repository;

import com.backend.Meal.domain.DormMenu;
import com.backend.Meal.dto.DormResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.backend.Meal.presentation.status.MealType;

import java.time.LocalDate;
import java.util.List;

public interface DormMenuRepository extends JpaRepository<DormMenu, Long> {

    @Query("SELECT new com.backend.Meal.dto.DormResponse(d.menuType, d.menu) " +
            "FROM DormMenu d WHERE d.date = :date AND d.mealType = :mealType")
    List<DormResponse> findDormMenuDtoByDateAndMealType(@Param("date") LocalDate date, @Param("mealType") MealType mealType);

}
