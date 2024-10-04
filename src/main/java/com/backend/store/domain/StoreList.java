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
import java.util.stream.Collectors;

public class StoreList {
    private final List<Store> stores;

    public StoreList(List<Store> stores) {
        this.stores = new ArrayList<>(stores);
    }

    public static StoreList createTwoRecommendationStoreList(PriceRange priceRange, Area area, List<Store> allStores) {
        List<Store> filteredRestaurantStores = getFilteredStores(priceRange, area, allStores, RESTAURANT);
        List<Store> filteredCafeStores = getFilteredStores(priceRange, area, allStores, CAFE);

        validateMinTwoStores(filteredRestaurantStores, filteredCafeStores);
        return new StoreList(createFilteredStores(filteredRestaurantStores, filteredCafeStores));
    }

    private static List<Store> getFilteredStores(PriceRange priceRange, Area area, List<Store> allStores, CategoryMajor categoryMajor) {
        return allStores.stream()
                .filter(store -> store.getPriceRange().equals(priceRange))
                .filter(store -> store.getArea().equals(area) || area == Area.ALL)
                .filter(store -> store.getCategoryMajor().equals(categoryMajor))
                .collect(Collectors.toList());
    }

    private static List<Store> createFilteredStores(List<Store> filteredRestaurantStores, List<Store> filteredCafeStores) {
        List<Store> filteredStores = new ArrayList<>(filteredRestaurantStores);
        filteredStores.addAll(filteredCafeStores);
        return filteredStores;
    }

    private static void validateMinTwoStores(List<Store> restaurant, List<Store> cafe) {
        if (restaurant.isEmpty() || cafe.isEmpty()) {
            throw new StoreException(StoreExceptionType.STORE_NOT_FOUND);
        }
    }

    public static StoreList createOneRecommendationStoreList(PriceRange priceRange, Area area, CategoryMajor category, List<Store> allStores) {
        List<Store> filteredStores = allStores.stream()
                .filter(store -> store.getPriceRange().equals(priceRange))
                .filter(store -> store.getArea().equals(area) || area == Area.ALL)
                .filter(store -> store.getCategoryMajor().equals(category))
                .collect(Collectors.toList());
        validateMinOneStore(filteredStores);
        return new StoreList(filteredStores);
    }

    public static StoreList createOneReloadStoreList(Long targetStoreId, Long anotherStoreId, PriceRange priceRange, Area area, CategoryMajor categoryMajor, List<Store> allStores) {
        List<Store> filteredStores = allStores.stream()
                .filter(store -> !store.getStoreId().equals(targetStoreId) && !store.getStoreId().equals(anotherStoreId))
                .filter(store -> store.getPriceRange().equals(priceRange))
                .filter(store -> store.getArea().equals(area) || area == Area.ALL)
                .filter(store -> store.getCategoryMajor().equals(categoryMajor))
                .collect(Collectors.toList());
        validateMinOneStore(filteredStores);
        return new StoreList(filteredStores);
    }

    private static void validateMinOneStore(List<Store> stores) {
        if (stores.isEmpty()) {
            throw new StoreException(StoreExceptionType.STORE_NOT_FOUND);
        }
    }

    public List<StoreResponse> getOneRandomRestaurantAndOneRandomCafe() {
        shuffleStores();
        List<Store> restaurants = stores.stream()
                .filter(store -> store.getCategoryMajor().equals(RESTAURANT))
                .toList();

        List<Store> cafes = stores.stream()
                .filter(store -> store.getCategoryMajor().equals(CAFE))
                .toList();

        return new ArrayList<>(List.of(toStoreResponse(restaurants.get(0)), toStoreResponse(cafes.get(0))));
    }

    public StoreResponse getOneRandomStore() {
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
