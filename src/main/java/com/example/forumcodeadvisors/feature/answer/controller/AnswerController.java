package com.example.forumcodeadvisors.feature.answer.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;
import com.example.forumcodeadvisors.feature.answer.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<?> createAnswer(@Valid @RequestBody CreateAnswerRequest createAnswerRequest) {
        return answerService.createAnswer(createAnswerRequest);
    }

    @GetMapping("/{answerUuid}")
    public ParentAnswerResponse findAnswerByUuid(@PathVariable String answerUuid) {
        return answerService.findAnswerByUuid(answerUuid);
    }

    @GetMapping("/{questionUuid}/question")
    public Page<ParentAnswerResponse> findAllQuestionByQuestionUuid(@PathVariable String questionUuid,
                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        return answerService.findAllQuestionByQuestionUuid(questionUuid, page, size);
    }

    @DeleteMapping("/{answerUuid}/soft-delete")
    public BaseResponse<?> deleteAnswer(@PathVariable String answerUuid) {
        return answerService.deleteAnswer(answerUuid, null);
    }

    @PutMapping("/{answerUuid}/{authorUuid}/accepted")
    public BaseResponse<?> acceptAnswer(@PathVariable String answerUuid, @PathVariable String authorUuid) {
        return answerService.acceptAnswer(answerUuid, authorUuid);
    }
}
