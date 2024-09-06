package com.backend.store.domain.response;

import com.backend.store.presentation.status.PriceRange;

public record StoreResponse(Long storeId, String storeName, double latitude, double longitude, PriceRange priceRange, String storeUrl) {
}
