package com.backend.Meal.domain;

import com.backend.Meal.presentation.status.MealFor;
import com.backend.Meal.presentation.status.MealType;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "hall_menu")
@Getter
public class HallMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallMenuId;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Enumerated(EnumType.STRING)
    private MealFor mealFor;

    private String hall2_Menu;
    private String hall3_Menu;
    private String hall4_Menu;
    private String cheMenu;

}
