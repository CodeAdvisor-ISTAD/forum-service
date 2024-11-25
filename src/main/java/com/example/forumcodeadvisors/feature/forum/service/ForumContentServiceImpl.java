package com.example.forumcodeadvisors.feature.forum.service;

import com.example.forumcodeadvisors.domain.ForumContent;
import com.example.forumcodeadvisors.feature.forum.dto.CreateForumRequest;
import com.example.forumcodeadvisors.feature.forum.mapper.ForumContentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class ForumContentServiceImpl implements ForumContentService {

    private final ForumContentMapper forumContentMapper;

    /**
     * Create forum content
     * @param createForumRequest
     * @return void
     * by Yith Sopheaktra
     */
    @Override
    public void createForumContent(CreateForumRequest createForumRequest) {

        ForumContent forumContent = forumContentMapper.fromCreateForumRequest(createForumRequest);

        forumContent.setUuid(UUID.randomUUID().toString());

        // set null to interactionId when create new post
        forumContent.setInteractionId(null);


    }
}
