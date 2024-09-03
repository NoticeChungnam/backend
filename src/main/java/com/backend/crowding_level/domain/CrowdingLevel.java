package com.backend.crowding_level.domain;

import com.backend.crowding_level.presentation.status.LocationType;
import jakarta.persistence.*;

@Entity
@Table(name = "crowding_level")
public class CrowdingLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long CrowdingId;

    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    private Long peopleCount;

}

