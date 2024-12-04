package com.example.forumcodeadvisors.feature.question.dto;

public record QuestionResponse(
        String uuid,
        String authorUuid,
        String title,
        String description,
        String content,
        String introduction,
        String expectedAnswers,
        Boolean isDrafted,
        Boolean isArchived,
        Boolean isDeleted,
        String createdAt,
        String updatedAt
) {
}
