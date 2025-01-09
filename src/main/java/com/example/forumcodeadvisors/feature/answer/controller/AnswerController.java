package com.example.forumcodeadvisors.feature.answer.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.AcceptAnswerRequest;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;
import com.example.forumcodeadvisors.feature.answer.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<?> createAnswer(@Valid @RequestBody CreateAnswerRequest createAnswerRequest,
                                        @AuthenticationPrincipal Jwt jwt) {
        return answerService.createAnswer(createAnswerRequest, jwt);
    }

    @GetMapping("/{answerUuid}")
    public ParentAnswerResponse findAnswerByUuid(@PathVariable String answerUuid) {
        return answerService.findAnswerByUuid(answerUuid);
    }

    @GetMapping("/{questionSlug}/question")
    public Page<ParentAnswerResponse> findAllQuestionByQuestionUuid(@PathVariable String questionSlug,
                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        return answerService.findAllQuestionByQuestionSlug(questionSlug, page, size);
    }

    @DeleteMapping("/{answerUuid}/soft-delete")
    public BaseResponse<?> deleteAnswer(@PathVariable String answerUuid) {
        return answerService.deleteAnswer(answerUuid, answerUuid);
    }

    @PutMapping("/accepted")
    public BaseResponse<?> acceptAnswer(@RequestBody AcceptAnswerRequest acceptAnswerRequest, @AuthenticationPrincipal Jwt jwt) {
        return answerService.acceptAnswer(acceptAnswerRequest, jwt);
    }

    @PutMapping("/un-accepted")
    public BaseResponse<?> unAcceptAnswer(@RequestBody AcceptAnswerRequest acceptAnswerRequest, @AuthenticationPrincipal Jwt jwt) {
        return answerService.unAcceptAnswer(acceptAnswerRequest, jwt);
    }
}
