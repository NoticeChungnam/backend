package com.backend.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class CommonHeader {
    private final boolean isSuccessful;
    private final HttpStatus httpStatus;
    private final String resultMessage;

    @Builder
    private CommonHeader(HttpStatus httpStatus, String resultMessage) {
        httpStatus = Objects.isNull(httpStatus) ? HttpStatus.OK : httpStatus;
        resultMessage = Objects.isNull(resultMessage) ? httpStatus.getReasonPhrase() : resultMessage;

        this.isSuccessful = httpStatus.is2xxSuccessful();
        this.httpStatus = httpStatus;
        this.resultMessage = resultMessage;
    }
}
