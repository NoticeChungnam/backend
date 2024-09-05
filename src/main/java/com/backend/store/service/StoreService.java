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
        List<StoreResponse> storeResponses = storeRepository.findRecommendStores(storeRequest.priceRange(), storeRequest.area(), storeRequest.category());
        if(storeResponses.size() < 2) {
            throw new StoreException(StoreExceptionType.STORE_NOT_FOUND);
        }
        return storeResponses;
    }

    public StoreResponse reloadStore(Long targetStoreId, Long anotherStoreId) {
        StoreResponse storeResponse = storeRepository.findNewStore(targetStoreId, anotherStoreId);
        if(storeResponse == null) {
            throw new StoreException(StoreExceptionType.STORE_NOT_FOUND);
        }
        return storeResponse;
    }
}
