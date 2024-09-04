package com.backend.crowding_level.controller;

import com.backend.common.response.CommonResponse;
import com.backend.crowding_level.dto.response.ConfusionResponse;
import com.backend.crowding_level.service.CrowdingLevelService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/confusions")
public class CrowdingLevelController {
    private final CrowdingLevelService crowdingLevelService;

    @GetMapping
    public CommonResponse<List<ConfusionResponse>> getConfusion() {
        List<ConfusionResponse> confusionResponseList = crowdingLevelService.getConfusion();
        return CommonResponse.success(confusionResponseList, HttpStatus.OK, "혼잡도 정보를 불러오는데 성공하였습니다.");
    }
}
