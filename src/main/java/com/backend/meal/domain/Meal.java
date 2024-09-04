package com.backend.meal.domain;

import com.backend.meal.presentation.status.MealType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "meal")
@Getter
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mealId;

    @Enumerated(EnumType.STRING)
    private MealType mealType;
    private String location;
    private String menuName;
    private String description;
    private Long price;

}
