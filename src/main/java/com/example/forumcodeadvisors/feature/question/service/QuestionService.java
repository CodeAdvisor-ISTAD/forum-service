package com.example.forumcodeadvisors.feature.question.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    BaseResponse<?> createQuestion(CreateQuestionRequest createForumRequest);

    BaseResponse<?> publishQuestion(String questionUuid, String userUuid);

    BaseResponse<?> deleteQuestion(String questionUuid);

    BaseResponse<?> archiveQuestion(String questionUuid);

    BaseResponse<?> unarchiveQuestion(String questionUuid);

    Page<QuestionResponse> findAllQuestions(int page, int size);

    Page<QuestionResponse> findAllUnArchivedQuestions(int page, int size);

    QuestionResponse findQuestionByUuid(String questionUuid);



}
