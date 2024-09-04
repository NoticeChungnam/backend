package com.backend.common.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CommonListResponse<T> {
    private final CommonHeader header;
    private final List<T> resultList;
    private final int totalCount;

    @Builder
    private CommonListResponse(CommonHeader header, List<T> resultList, int totalCount) {
        this.header = header;
        this.resultList = resultList;
        this.totalCount = totalCount;
    }
}
