package com.backend.store.service;

import com.backend.store.domain.request.StoreRequest;
import com.backend.store.domain.response.StoreResponse;
import com.backend.store.exception.StoreException;
import com.backend.store.exception.StoreExceptionType;
import com.backend.store.repository.StoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreResponse> getRecommendations(StoreRequest storeRequest) {
        List<StoreResponse> storeResponses = storeRepository.findRecommendStores(storeRequest.priceRange(), storeRequest.area(), storeRequest.category())
                .filter(storeResponsesList -> storeResponsesList.size() >= 2)
                .orElseThrow(() -> new StoreException(StoreExceptionType.STORE_NOT_FOUND));

        return StoreResponse.selectRandomStores(storeResponses, 2);
    }

    public StoreResponse reloadStore(Long targetStoreId, Long anotherStoreId) {
        List<StoreResponse> storeResponses = storeRepository.findNewStore(targetStoreId, anotherStoreId)
                .filter(storeResponsesList -> !storeResponsesList.isEmpty())
                .orElseThrow(() -> new StoreException(StoreExceptionType.STORE_NOT_FOUND));

        return StoreResponse.selectRandomStores(storeResponses, 1).get(0);
    }
}
