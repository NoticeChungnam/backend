package com.backend.store.domain;

import com.backend.store.presentation.status.CategoryMajor;
import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long storeId;

    private String storeName;

    @Enumerated(EnumType.STRING)
    private CategoryMajor CategoryMajor;

    private String CategoryMinor;
    private String address;
    private double latitude;
    private double longitude;
    private Long averagePrice;
    private String storeUrl;
    private String signatureMenu;
    private String comment;

}
