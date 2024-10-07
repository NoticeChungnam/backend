package com.backend.store.dto.response;

import com.backend.store.presentation.status.PriceRange;

public record StoreResponse(Long storeId, String storeName, Double latitude, Double longitude, PriceRange priceRange, String storeUrl, String category, String area) {
}
