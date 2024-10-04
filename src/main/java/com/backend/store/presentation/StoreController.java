package com.backend.store.presentation;

import com.backend.common.response.CommonResponse;
import com.backend.store.dto.request.StoreReloadRequest;
import com.backend.store.dto.request.StoreRequest;
import com.backend.store.dto.response.StoreResponse;
import com.backend.store.presentation.status.Area;
import com.backend.store.presentation.status.PriceRange;
import com.backend.store.service.StoreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/recommendations")
    public CommonResponse<List<StoreResponse>> getRecommendations(@RequestBody StoreRequest storeRequest) {
        PriceRange priceRange = storeRequest.priceRange();
        Area area = storeRequest.area();
        List<StoreResponse> storeResponses = storeService.getRecommendations(priceRange, area);
        return CommonResponse.success(storeResponses, HttpStatus.OK, "추천 맛집 반환에 성공하였습니다.");
    }

    @PostMapping("/recommendation")
    public CommonResponse<StoreResponse> getRecommendation(@RequestBody StoreRequest storeRequest) {
        StoreResponse storeResponse = storeService.getRecommendation(
                storeRequest.priceRange(),
                storeRequest.area(),
                storeRequest.category()
        );
        return CommonResponse.success(storeResponse, HttpStatus.OK, "추천 맛집 반환에 성공하였습니다.");
    }

    @PostMapping("/reload")
    public CommonResponse<StoreResponse> reloadStore(@RequestBody StoreReloadRequest storeReloadRequest) {
        StoreResponse storeResponse = storeService.reloadStore(
                storeReloadRequest.targetStoreId(),
                storeReloadRequest.anotherStoreId(),
                storeReloadRequest.priceRange(),
                storeReloadRequest.area(),
                storeReloadRequest.category()
        );
        return CommonResponse.success(storeResponse, HttpStatus.OK, "새로운 맛집 반환에 성공하였습니다.");
    }
}
