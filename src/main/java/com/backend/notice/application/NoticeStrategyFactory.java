package com.backend.notice.application;

import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.dto.NoticeResponse.*;
import com.backend.notice.dto.NoticeResponseType;
import com.backend.notice.presentation.status.NoticeCategory;
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
                .collect(Collectors.toMap(
                        strategy -> NoticeCategory.valueOf(
                                strategy.getClass().getSimpleName().replace("NoticeStrategy", "").toUpperCase()),
                        strategy -> strategy));
    }

    public List<? extends NoticeResponseType> getNotices(NoticeCategory category) {
        NoticeStrategy strategy = strategyMap.get(category);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown category: " + category);
        }
        return strategy.getNotices();
    }

}
