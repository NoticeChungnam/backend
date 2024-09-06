package com.backend.store.service;

import com.backend.store.domain.Store;
import com.backend.store.domain.StoreList;
import com.backend.store.domain.request.StoreRequest;
import com.backend.store.domain.response.StoreResponse;
import com.backend.store.repository.StoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreResponse> getRecommendations(StoreRequest storeRequest) {
        List<Store> stores = storeRepository.findAll();
        StoreList storeList = StoreList.createTwoStoreList(storeRequest, stores);
        return storeList.getTwoRandomStores();
    }

    public StoreResponse reloadStore(Long targetStoreId, Long anotherStoreId) {
        List<Store> stores = storeRepository.findAll();
        StoreList storeList = StoreList.createOneStoreList(targetStoreId, anotherStoreId, stores);
        return storeList.getOneRandomStore();
    }
}
