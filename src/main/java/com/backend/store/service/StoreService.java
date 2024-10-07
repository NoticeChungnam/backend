package com.backend.store.service;

import com.backend.store.domain.Store;
import com.backend.store.domain.StoreList;
import com.backend.store.dto.response.StoreResponse;
import com.backend.store.domain.repository.StoreRepository;
import com.backend.store.presentation.status.Area;
import com.backend.store.presentation.status.CategoryMajor;
import com.backend.store.presentation.status.PriceRange;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreResponse> getRecommendations(PriceRange priceRange, Area area) {
        return getStoreList().getTwoRecommendationStoreList(priceRange, area);
    }

    public StoreResponse getRecommendation(PriceRange priceRange, Area area, CategoryMajor category) {
        return getStoreList().getOneRecommendationStoreList(priceRange, area, category);
    }

    public StoreResponse reloadStore(Long targetStoreId, Long anotherStoreId, PriceRange priceRange, Area area, CategoryMajor category) {
        return getStoreList().getOneReloadStoreList(targetStoreId, anotherStoreId, priceRange, area, category);
    }

    private StoreList getStoreList() {
        List<Store> stores = storeRepository.findAll();
        return StoreList.of(stores);
    }
}
