package com.backend.department.dto.response;

import java.time.LocalDateTime;

public record ArticleDetailsResponse(String articleTitle, LocalDateTime updatedAt, String writerName) {
}
