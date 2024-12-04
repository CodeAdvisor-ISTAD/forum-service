package com.example.forumcodeadvisors.feature.answer.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;

public interface AnswerService {

    BaseResponse<?> createAnswer(CreateAnswerRequest createAnswerRequest);

    ParentAnswerResponse findAnswerByUuid(String answerUuid);
}
