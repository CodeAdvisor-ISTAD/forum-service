package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.vote.dto.TotalVoteResponse;

public interface VoteService {


    BaseResponse<?> voteQuestion(String questionUuid, String userUuid);

    TotalVoteResponse totalQuestionVotes(String questionUuid);

    BaseResponse<?> voteAnswer(String answerUuid, String userUuid);

    TotalVoteResponse totalAnswerVotes(String answerUuid);

    BaseResponse<?> downVoteQuestion(String questionUuid, String userUuid);

    BaseResponse<?> downVoteAnswer(String answerUuid, String userUuid);

    BaseResponse<?> checkUserIsVotedOnQuestion(String questionUuid, String userUuid);

    BaseResponse<?> checkUserIsVotedOnAnswer(String answerUuid, String userUuid);
}
