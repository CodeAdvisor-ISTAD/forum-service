package com.example.forumcodeadvisors.feature.forum.dto;

import java.util.List;

public record CreateForumRequest(
        String authorId,
        String title,
        String content,
        List<String> tags
) {
}
