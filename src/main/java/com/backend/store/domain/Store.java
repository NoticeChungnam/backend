package com.backend.store.domain;

import com.backend.store.presentation.status.Area;
import com.backend.store.presentation.status.CategoryMajor;
import com.backend.store.presentation.status.PriceRange;
import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long storeId;

    private String storeName;

    @Enumerated(EnumType.STRING)
    private CategoryMajor categoryMajor;

    private String categoryMinor;

    @Enumerated(EnumType.STRING)
    private Area area;
    private String address;
    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    private PriceRange priceRange;

    private String storeUrl;
    private String signatureMenu;
    private String comment;

}
