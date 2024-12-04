package com.example.forumcodeadvisors.feature.answer.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;
import com.example.forumcodeadvisors.feature.answer.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
