package com.example.forumcodeadvisors.feature.question.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateQuestionRequest(
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank
        String slug,
        @NotEmpty(message = "Tags are required")
        List<String> tagName,
        @NotBlank(message = "Introduction is required")
        String introduction,
        String expectedAnswers,
        Boolean isDrafted
) {
}
