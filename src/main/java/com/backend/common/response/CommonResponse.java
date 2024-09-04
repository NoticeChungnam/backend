package com.backend.common.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponse<T> {

    private final CommonHeader header;
    private final T result;

    @Builder
    private CommonResponse(CommonHeader header, T result) {
        this.header = header;
        this.result = result;
    }

    public static <T> CommonResponse<T> noContent(HttpStatus status) {
        return CommonResponse.<T>builder()
                .header(
                        CommonHeader.builder()
                                .httpStatus(status)
                                .build()
                )
                .result(null)
                .build();
    }

    public static <T> CommonResponse<T> noContent(HttpStatus status, String message) {
        return CommonResponse.<T>builder()
                .header(
                        CommonHeader.builder()
                        .httpStatus(status)
                        .resultMessage(message)
                        .build()
                )
                .result(null)
                .build();
    }

    public static <T> CommonResponse<T> success(T result, HttpStatus status, String message) {
        return CommonResponse.<T>builder()
                .header(
                        CommonHeader.builder()
                                .httpStatus(status)
                                .resultMessage(message)
                                .build()
                )
                .result(result)
                .build();
    }

}
