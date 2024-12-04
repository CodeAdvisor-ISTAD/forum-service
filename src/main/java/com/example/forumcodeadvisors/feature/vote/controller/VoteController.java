package com.example.forumcodeadvisors.feature.vote.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.vote.service.VoteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Setter
@Getter
@RequestMapping("/api/v1/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/question/{questionUuid}/user/{userUuid}")
    public BaseResponse<?> voteQuestion(@PathVariable String questionUuid, @PathVariable String userUuid) {
        return voteService.voteQuestion(questionUuid, userUuid);
    }

    @GetMapping("/{questionUuid}/total-votes")
    public Integer totalQuestionVotes(@PathVariable  String questionUuid) {
        return voteService.totalQuestionVotes(questionUuid);
    }
}
