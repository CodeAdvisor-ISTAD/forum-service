package com.example.forumcodeadvisors.feature.answer.dto;

import java.util.List;

public record ParentAnswerResponse(
        String uuid,
        String authorUuid,
        String questionSlug,
        String slug,
        Boolean isParent,
        Boolean isAccepted,
        String content,
        String createdAt,
        String updatedAt,
        List<AnswerResponse> replies
) {
}
