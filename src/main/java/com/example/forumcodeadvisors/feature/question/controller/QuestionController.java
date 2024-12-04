package com.example.forumcodeadvisors.feature.question.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import com.example.forumcodeadvisors.feature.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BaseResponse<?> createQuestion(@Valid @RequestBody CreateQuestionRequest createQuestionRequest) {
        return questionService.createQuestion(createQuestionRequest);
    }

    @PostMapping("/{questionUuid}/publish")
    public BaseResponse<?> publishQuestion(@PathVariable String questionUuid) {
        return questionService.publishQuestion(questionUuid);
    }

    @DeleteMapping("/{questionUuid}/soft-delete")
    public BaseResponse<?> deleteQuestion(@PathVariable String questionUuid) {
        return questionService.deleteQuestion(questionUuid);
    }

    @PostMapping("/{questionUuid}/archive")
    public BaseResponse<?> archiveQuestion(@PathVariable String questionUuid) {
        return questionService.archiveQuestion(questionUuid);
    }

    @PostMapping("/{questionUuid}/unarchive")
    public BaseResponse<?> unarchiveQuestion(@PathVariable String questionUuid) {
        return questionService.unarchiveQuestion(questionUuid);
    }

    @GetMapping
    public List<QuestionResponse> findAllQuestions() {
        return questionService.findAllQuestions();
    }

    @GetMapping("/{questionUuid}")
    public QuestionResponse findQuestionByUuid(@PathVariable String questionUuid) {
        return questionService.findQuestionByUuid(questionUuid);
    }

}
