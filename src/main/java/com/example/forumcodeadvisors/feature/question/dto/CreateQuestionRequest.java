package com.example.forumcodeadvisors.feature.question.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateQuestionRequest(
        @NotBlank(message = "Author UUID is required")
        String authorUuid,
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank
        String slug,
        @NotBlank(message = "Content is required")
        String content,
        @NotEmpty(message = "Tags are required")
        List<Long> tagIds,
        @NotBlank(message = "Introduction is required")
        String introduction,
        String expectedAnswers,
        String description,
        Boolean isDrafted
) {
}
