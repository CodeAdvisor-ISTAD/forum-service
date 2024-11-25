package com.example.forumcodeadvisors.feature.forum.service;

import com.example.forumcodeadvisors.feature.forum.dto.CreateForumRequest;
import org.springframework.stereotype.Service;

@Service
public interface ForumContentService {


    void createForumContent(CreateForumRequest createForumRequest);

}
