package com.example.forumcodeadvisors.feature.answer.dto;

public record AnswerResponse(
        String uuid,
        String authorUuid,
        String questionSlug,
        String slug,
        String content,
        String createdAt,
        String updatedAt
) {
}
