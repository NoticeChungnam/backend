package com.backend.store.controller;

import com.backend.common.response.CommonResponse;
import com.backend.store.domain.request.StoreRequest;
import com.backend.store.domain.response.StoreResponse;
import com.backend.store.service.StoreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/recommendations")
    public CommonResponse<List<StoreResponse>> getRecommendations(@RequestBody StoreRequest storeRequest) {
        List<StoreResponse> storeResponses = storeService.getRecommendations(storeRequest);
        return CommonResponse.success(storeResponses, HttpStatus.OK, "추천 맛집 반환에 성공하였습니다.");
    }

    @GetMapping("/reload")
    public CommonResponse<StoreResponse> reloadStore(
            @RequestParam("target_store") Long targetStoreId,
            @RequestParam("another_store") Long anotherStoreId) {
        StoreResponse storeResponse = storeService.reloadStore(targetStoreId, anotherStoreId);
        return CommonResponse.success(storeResponse, HttpStatus.OK, "새로운 맛집 반환에 성공하였습니다.");
    }
}
