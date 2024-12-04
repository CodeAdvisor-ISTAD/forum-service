package com.example.forumcodeadvisors.feature.answer.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateAnswerRequest(
        @NotBlank
        String userUuid,

        @NotBlank
        String questionUuid,

        String answerUuid,

        @NotBlank
        String slug,

        @NotBlank
        String content
) {
}
