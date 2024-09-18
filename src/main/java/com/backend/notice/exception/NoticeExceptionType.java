package com.backend.notice.exception;

import com.backend.common.exception.BaseExceptionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@RequiredArgsConstructor
public enum NoticeExceptionType implements BaseExceptionType {

    NOTICE_NOT_FOUND(BAD_REQUEST, "불러올 게시글이 존재하지 않습니다."),
    CATEGORY_NOT_FOUND(BAD_REQUEST, "존재하지 않는 게시판 종류입니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }

}
