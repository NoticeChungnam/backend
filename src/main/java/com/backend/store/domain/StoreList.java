package com.backend.store.domain;


import static com.backend.store.presentation.status.CategoryMajor.CAFE;
import static com.backend.store.presentation.status.CategoryMajor.RESTAURANT;

import com.backend.store.dto.response.StoreResponse;
import com.backend.store.exception.StoreException;
import com.backend.store.exception.StoreExceptionType;
import com.backend.store.presentation.status.Area;
import com.backend.store.presentation.status.CategoryMajor;
import com.backend.store.presentation.status.PriceRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreList {
    private final List<Store> stores;

    public StoreList(List<Store> stores) {
        this.stores = new ArrayList<>(stores);
    }

    public static StoreList of(List<Store> stores) {
        return new StoreList(stores);
    }

    public StoreResponse getOneReloadStoreList(Long targetStoreId, Long anotherStoreId, PriceRange priceRange, Area area, CategoryMajor categoryMajor) {
        return getFilteredOneStore(targetStoreId, anotherStoreId, priceRange, area, categoryMajor);
    }

    public StoreResponse getOneRecommendationStoreList(PriceRange priceRange, Area area, CategoryMajor category) {
        return getFilteredOneStore(null, null, priceRange, area, category);
    }

    public List<StoreResponse> getTwoRecommendationStoreList(PriceRange priceRange, Area area) {
        StoreResponse filteredRestaurantStores = getFilteredOneStore(null, null, priceRange, area, RESTAURANT);
        StoreResponse filteredCafeStores = getFilteredOneStore(null, null, priceRange, area, CAFE);

        return new ArrayList<>(List.of(filteredRestaurantStores, filteredCafeStores));
    }

    private StoreResponse getFilteredOneStore(Long targetStoreId, Long anotherStoreId, PriceRange priceRange, Area area, CategoryMajor categoryMajor) {
         List<Store> storeList = stores.stream()
                .filter(store -> (!store.getStoreId().equals(targetStoreId) && !store.getStoreId().equals(anotherStoreId))
                        || targetStoreId == null || anotherStoreId == null)
                .filter(store -> store.getPriceRange().equals(priceRange))
                .filter(store -> store.getArea().equals(area) || area == Area.ALL)
                .filter(store -> store.getCategoryMajor().equals(categoryMajor))
                .toList();
         validateStore(storeList);
         return new StoreList(storeList).getOneRandomStore();
    }

    private void validateStore(List<Store> stores) {
        if (stores.isEmpty()) {
            throw new StoreException(StoreExceptionType.STORE_NOT_FOUND);
        }
    }

    private StoreResponse getOneRandomStore() {
        shuffleStores();
        return toStoreResponse(stores.get(0));
    }

    private void shuffleStores() {
        Collections.shuffle(stores);
    }

    private StoreResponse toStoreResponse(Store store) {
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
