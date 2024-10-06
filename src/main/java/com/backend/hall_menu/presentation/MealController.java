package com.backend.hall_menu.presentation;

import com.backend.common.response.CommonResponse;
import com.backend.hall_menu.dto.MealResponse;
import com.backend.hall_menu.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping
    public CommonResponse<List<MealResponse>> getMeal() {
        List<MealResponse> mealResponses = mealService.getMeal();
        return CommonResponse.success(mealResponses, HttpStatus.OK, "학식 정보를 불러왔습니다.");
    }

}
