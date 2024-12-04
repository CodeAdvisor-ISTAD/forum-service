package com.example.forumcodeadvisors.feature.answer.dto;

import java.util.List;

public record AnswerResponse(
        String uuid,
        String userUuid,
        String questionUuid,
        String slug,
        String content,
        String createdAt,
        String updatedAt
) {
}
