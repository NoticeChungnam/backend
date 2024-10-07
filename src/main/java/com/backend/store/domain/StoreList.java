package com.backend.store.domain;


import static com.backend.store.presentation.status.CategoryMajor.CAFE;
import static com.backend.store.presentation.status.CategoryMajor.RESTAURANT;

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

    public Store getOneReloadStore(Long targetStoreId, Long anotherStoreId, PriceRange priceRange, Area area, CategoryMajor categoryMajor) {
        return getFilteredOneStore(targetStoreId, anotherStoreId, priceRange, area, categoryMajor);
    }

    public Store getOneRecommendationStore(PriceRange priceRange, Area area, CategoryMajor category) {
        return getFilteredOneStore(null, null, priceRange, area, category);
    }

    public List<Store> getTwoRecommendationStoreList(PriceRange priceRange, Area area) {
        Store filteredRestaurantStores = getFilteredOneStore(null, null, priceRange, area, RESTAURANT);
        Store filteredCafeStores = getFilteredOneStore(null, null, priceRange, area, CAFE);

        return new ArrayList<>(List.of(filteredRestaurantStores, filteredCafeStores));
    }

    private Store getFilteredOneStore(Long targetStoreId, Long anotherStoreId, PriceRange priceRange, Area area, CategoryMajor categoryMajor) {
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

    private Store getOneRandomStore() {
        shuffleStores();
        return stores.get(0);
    }

    private void shuffleStores() {
        Collections.shuffle(stores);
    }
}
