package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;

public interface VoteService {


    BaseResponse<?> voteQuestion(String questionUuid, String userUuid);

    Integer totalQuestionVotes(String questionUuid);


}
