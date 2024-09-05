package com.backend.store.domain.response;

import com.backend.store.presentation.status.PriceRange;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record StoreResponse(Long storeId, String storeName, double latitude, double longitude, PriceRange priceRange, String storeUrl) {

    public static List<StoreResponse> selectRandomStores(List<StoreResponse> storeResponses, int limit) {
        Collections.shuffle(storeResponses);
        return storeResponses.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
