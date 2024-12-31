package com.example.forumcodeadvisors.feature.answer.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface AnswerService {

    BaseResponse<?> createAnswer(CreateAnswerRequest createAnswerRequest);

    ParentAnswerResponse findAnswerByUuid(String answerUuid);

    Page<ParentAnswerResponse> findAllQuestionByQuestionUuid(String questionUuid, int page, int size);

    BaseResponse<?> deleteAnswer(String answerUuid, String authorUuid);

    BaseResponse<?> acceptAnswer(String answerUuid, String authorUuid);

}
