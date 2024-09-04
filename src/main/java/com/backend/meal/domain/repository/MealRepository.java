package com.backend.meal.domain.repository;

import com.backend.meal.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {


}
