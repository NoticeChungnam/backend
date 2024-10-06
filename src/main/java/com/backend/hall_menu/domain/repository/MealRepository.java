package com.backend.hall_menu.domain.repository;

import com.backend.hall_menu.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {


}
