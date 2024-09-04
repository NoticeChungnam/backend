package com.backend.crowding_level.service;

import static com.backend.crowding_level.exception.CrowdingExceptionType.CROWDING_NOT_FOUND;

import com.backend.crowding_level.dto.response.ConfusionResponse;
import com.backend.crowding_level.exception.CrowdingException;
import com.backend.crowding_level.repository.CrowdingLevelRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrowdingLevelService {
    private final CrowdingLevelRepository crowdingLevelRepository;

    public List<ConfusionResponse> getConfusion() {
        List<ConfusionResponse> confusions = crowdingLevelRepository.findAllConfusions();
        if (confusions.isEmpty()) {
            throw new CrowdingException(CROWDING_NOT_FOUND);
        }
        return crowdingLevelRepository.findAllConfusions();
    }
}
