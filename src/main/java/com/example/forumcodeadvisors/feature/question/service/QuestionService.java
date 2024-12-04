package com.example.forumcodeadvisors.feature.question.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    BaseResponse<?> createQuestion(CreateQuestionRequest createForumRequest);

    BaseResponse<?> publishQuestion(String questionUuid);

    BaseResponse<?> deleteQuestion(String questionUuid);

    BaseResponse<?> archiveQuestion(String questionUuid);

    BaseResponse<?> unarchiveQuestion(String questionUuid);

    List<QuestionResponse> findAllQuestions();

    QuestionResponse findQuestionByUuid(String questionUuid);



}
