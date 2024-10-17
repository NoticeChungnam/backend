package com.backend.Meal.domain.repository;

import com.backend.Meal.domain.HallMenu;
import com.backend.Meal.presentation.status.MealType;
import com.backend.Meal.dto.HallResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HallMenuRepository extends JpaRepository<HallMenu, Long> {

    @Query("SELECT new com.backend.Meal.dto.HallResponse(h.mealFor, h.hall2_Menu, h.hall3_Menu, h.hall4_Menu, h.cheMenu) " +
            "FROM HallMenu h WHERE h.date = :date AND h.mealType = :mealType")
    List<HallResponse> findHallMenuDtoByDateAndMealType(@Param("date") LocalDate date, @Param("mealType") MealType mealType);

}
