package com.backend.store.domain;


import com.backend.store.domain.request.StoreRequest;
import com.backend.store.domain.response.StoreResponse;
import com.backend.store.exception.StoreException;
import com.backend.store.exception.StoreExceptionType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StoreList {
    private final List<Store> stores;

    public StoreList(List<Store> stores) {
        this.stores = new ArrayList<>(stores);
    }

    public static StoreList createTwoStoreList(StoreRequest storeRequest, List<Store> allStores) {
        List<Store> filteredStores = allStores.stream()
                .filter(store -> store.getPriceRange().equals(storeRequest.priceRange()))
                .filter(store -> store.getArea().equals(storeRequest.area()))
                .filter(store -> store.getCategoryMajor().equals(storeRequest.category()))
                .collect(Collectors.toList());
        validateMinTwoStores(filteredStores);
        return new StoreList(filteredStores);
    }

    public static void validateMinTwoStores(List<Store> stores) {
        if (stores.size() < 2) {
            throw new StoreException(StoreExceptionType.STORE_NOT_FOUND);
        }
    }

    public static StoreList createOneStoreList(Long firstStoreId, Long secondStoreId, List<Store> allStores) {
        List<Store> filteredStores = allStores.stream()
                .filter(store -> !store.getStoreId().equals(firstStoreId) && !store.getStoreId().equals(secondStoreId))
                .collect(Collectors.toList());
        validateMinOneStore(filteredStores);
        return new StoreList(filteredStores);
    }

    public static void validateMinOneStore(List<Store> stores) {
        if (stores.isEmpty()) {
            throw new StoreException(StoreExceptionType.STORE_NOT_FOUND);
        }
    }

    public List<StoreResponse> getTwoRandomStores() {
        shuffleStores();
        return stores.stream()
                .limit(2)
                .map(this::toStoreResponse)
                .toList();
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
                store.getStoreUrl()
        );
    }
}
