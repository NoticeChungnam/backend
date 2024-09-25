package com.backend.crowding_level.repository;

import com.backend.crowding_level.domain.CrowdingLevel;
import com.backend.crowding_level.dto.response.ConfusionResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CrowdingLevelRepository extends JpaRepository<CrowdingLevel, Long> {
    @Query("SELECT new com.backend.crowding_level.dto.response.ConfusionResponse(c.locationType, c.peopleCount) " +
            "FROM CrowdingLevel c")
    Optional<List<ConfusionResponse>> findAllConfusions();
}
