package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.vote.dto.TotalVoteResponse;

public interface VoteService {


    BaseResponse<?> voteQuestion(String questionUuid, String userUuid);

    TotalVoteResponse totalQuestionVotes(String questionUuid);

    BaseResponse<?> voteAnswer(String answerUuid, String userUuid);

}
