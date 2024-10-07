package com.backend.store.domain.mapper;

import com.backend.store.domain.Store;
import com.backend.store.dto.response.StoreResponse;

public class StoreMapper {
    public static StoreResponse toStoreResponse(Store store) {
        return new StoreResponse(
                store.getStoreId(),
                store.getStoreName(),
                store.getLatitude(),
                store.getLongitude(),
                store.getPriceRange(),
                store.getStoreUrl(),
                store.getCategoryMajor().getDescription(),
                store.getArea().getDescription()
        );
    }
}
