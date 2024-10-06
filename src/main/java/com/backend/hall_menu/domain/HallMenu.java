package com.backend.hall_menu.domain;

import com.backend.hall_menu.presentation.status.MealType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "hall_menu")
@Getter
public class HallMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mealId;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Enumerated(EnumType.STRING)
    private MealFor mealFor;

    private String hall2Menu;
    private String hall3Menu;
    private String hall4Menu;
    private String cheMenu;

}
