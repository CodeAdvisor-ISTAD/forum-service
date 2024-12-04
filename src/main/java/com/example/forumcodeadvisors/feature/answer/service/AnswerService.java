package com.example.forumcodeadvisors.feature.answer.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;

import java.util.List;

public interface AnswerService {

    BaseResponse<?> createAnswer(CreateAnswerRequest createAnswerRequest);

    ParentAnswerResponse findAnswerByUuid(String answerUuid);

    List<ParentAnswerResponse> findAllQuestionByQuestionUuid(String questionUuid);

    BaseResponse<?> deleteAnswer(String answerUuid, String authorUuid);

    BaseResponse<?> acceptAnswer(String answerUuid, String authorUuid);

}
