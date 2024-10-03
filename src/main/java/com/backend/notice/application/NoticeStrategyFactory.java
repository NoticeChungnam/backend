package com.backend.notice.application;

import com.backend.notice.domain.strategy.NoticeStrategy;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.presentation.status.NoticeCategory;
import com.backend.notice.presentation.status.NoticeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NoticeStrategyFactory {

    private final Map<NoticeCategory, NoticeStrategy> strategyMap;

    @Autowired
    public NoticeStrategyFactory(List<NoticeStrategy> strategies) {
        strategyMap = strategies.stream()
                .collect(Collectors.toMap(NoticeStrategy::getSupportedCategory, strategy -> strategy));
    }

    public List<NoticeResponse> getNotices(NoticeCategory category, NoticeType noticeType) {
        NoticeStrategy strategy = strategyMap.get(category);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown category: " + category);
        }
        return strategy.getNotices(noticeType);
    }

    public List<NoticeResponse> getAllNotices(NoticeCategory category) {
        NoticeStrategy strategy = strategyMap.get(category);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown category: " + category);
        }
        return strategy.getAllNotices();
    }

}
