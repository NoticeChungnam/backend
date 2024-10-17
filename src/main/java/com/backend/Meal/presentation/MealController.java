package com.backend.Meal.presentation;

import com.backend.Meal.application.MealService;
import com.backend.Meal.dto.DormResponse;
import com.backend.Meal.dto.HallResponse;
import com.backend.Meal.presentation.status.MealType;
import com.backend.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping("hall/{date}/{mealType}")
    public CommonResponse<List<HallResponse>> getHallMenu(@PathVariable("date") LocalDate date, @PathVariable("mealType") String mealType) {
        return CommonResponse.success(mealService.getHallMenu(date, MealType.from(mealType)), HttpStatus.OK, "학생식당 조회 성공");
    }

    @GetMapping("dorm/{date}/{mealType}")
    public CommonResponse<List<DormResponse>> getDormMenu(@PathVariable("date") LocalDate date, @PathVariable("mealType") String mealType) {
        return CommonResponse.success(mealService.getDormMenu(date, MealType.from(mealType)), HttpStatus.OK , "기숙사식당 조회 성공");
    }

}
