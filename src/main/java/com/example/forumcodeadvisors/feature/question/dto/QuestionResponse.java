package com.example.forumcodeadvisors.feature.question.dto;

import com.example.forumcodeadvisors.feature.tag.dto.TagResponse;

import java.util.List;

public record QuestionResponse(
        String uuid,
        String slug,
        String authorUuid,
        String title,
        String description,
        String expectedAnswers,
        List<TagResponse> tags,
        Boolean isDrafted,
        Boolean isArchived,
        Boolean isDeleted,
        String createdAt,
        String updatedAt

) {
}
