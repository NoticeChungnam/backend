package com.backend.store.repository;

import com.backend.store.domain.Store;
import com.backend.store.domain.response.StoreResponse;
import com.backend.store.presentation.status.Area;
import com.backend.store.presentation.status.CategoryMajor;
import com.backend.store.presentation.status.PriceRange;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT new com.backend.store.domain.response.StoreResponse(s.storeId, s.storeName, s.latitude, s.longitude, s.priceRange, s.storeUrl) " +
            "FROM Store s " +
            "WHERE s.priceRange = :priceRange " +
            "AND (:area = 'ALL' OR s.area = :area) " +
            "AND (:category = 'ALL' OR s.categoryMajor = :category) ")
    Optional<List<StoreResponse>> findRecommendStores(@Param("priceRange") PriceRange priceRange, @Param("area") Area area, @Param("category") CategoryMajor category);

    @Query("SELECT new com.backend.store.domain.response.StoreResponse(s.storeId, s.storeName, s.latitude, s.longitude, s.priceRange, s.storeUrl) " +
            "FROM Store s " +
            "WHERE s.storeId != :targetStoreId AND s.storeId != :anotherStoreId ")
    Optional<List<StoreResponse>> findNewStore(@Param("targetStoreId") Long targetStoreId, @Param("anotherStoreId") Long anotherStoreId);
}
