package com.backend.store.dto.request;

import com.backend.store.presentation.status.Area;
import com.backend.store.presentation.status.CategoryMajor;
import com.backend.store.presentation.status.PriceRange;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StoreReloadRequest(
        Long targetStoreId,
        Long anotherStoreId,
        @JsonProperty("price_range") PriceRange priceRange,
        Area area,
        CategoryMajor category
) {
}
