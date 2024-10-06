package com.backend.Meal.domain;

import com.backend.Meal.presentation.status.MealType;
import com.backend.Meal.presentation.status.MenuType;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Table(name = "dorm_menu")
@Entity
public class DormMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dormMenuId;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Enumerated(EnumType.STRING)
    private MenuType menuType;

    private String menu;
}
