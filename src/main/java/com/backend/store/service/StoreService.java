package com.backend.store.service;

import com.backend.store.domain.Store;
import com.backend.store.domain.StoreList;
import com.backend.store.domain.mapper.StoreMapper;
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
        List<Store> recommendationStoresList = getStoreList().getTwoRecommendationStoreList(priceRange, area);
        return recommendationStoresList.stream()
                .map(StoreMapper::toStoreResponse)
                .toList();
    }

    public StoreResponse getRecommendation(PriceRange priceRange, Area area, CategoryMajor category) {
        Store recommendationStore = getStoreList().getOneRecommendationStore(priceRange, area, category);
        return StoreMapper.toStoreResponse(recommendationStore);
    }

    public StoreResponse reloadStore(Long targetStoreId, Long anotherStoreId, PriceRange priceRange, Area area, CategoryMajor category) {
        Store reloadStore = getStoreList().getOneReloadStore(targetStoreId, anotherStoreId, priceRange, area, category);
        return StoreMapper.toStoreResponse(reloadStore);
    }

    private StoreList getStoreList() {
        List<Store> stores = storeRepository.findAll();
        return StoreList.of(stores);
    }
}
