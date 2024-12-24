package com.example.forumcodeadvisors.feature.vote.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.vote.dto.TotalVoteResponse;
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

    @PostMapping("/question")
    public BaseResponse<?> voteQuestion(@RequestParam String questionUuid,
                                        @RequestParam String userUuid) {
        return voteService.voteQuestion(questionUuid, userUuid);
    }

    @GetMapping("question/{questionUuid}/total-votes")
    public TotalVoteResponse totalQuestionVotes(@PathVariable  String questionUuid) {
        return voteService.totalQuestionVotes(questionUuid);
    }

    @PostMapping("/answers")
    public BaseResponse<?> voteAnswer(@RequestParam String answerUuid,
                                      @RequestParam String userUuid) {
        return voteService.voteAnswer(answerUuid, userUuid);
    }

    @GetMapping("answers/{answerUuid}/total-votes")
    public TotalVoteResponse totalAnswerVotes(@PathVariable String answerUuid) {
        return voteService.totalAnswerVotes(answerUuid);
    }


    @PostMapping("/question/down-vote")
        public BaseResponse<?> downVoteQuestion(@RequestParam String questionUuid,
                                           @RequestParam String userUuid) {
        return voteService.downVoteQuestion(questionUuid, userUuid);
    }

    @PostMapping("/answers/down-vote")
    public BaseResponse<?> downVoteAnswer(@RequestParam String answerUuid,
                                         @RequestParam String userUuid) {
        return voteService.downVoteAnswer(answerUuid, userUuid);
    }

    @GetMapping("/question/check-vote")
        public BaseResponse<?> checkUserIsVotedOnQuestion(@RequestParam String questionUuid,
                                                     @RequestParam String userUuid) {
        return voteService.checkUserIsVotedOnQuestion(questionUuid, userUuid);
    }

    @GetMapping("/answers/check-vote")
    public BaseResponse<?> checkUserIsVotedOnAnswer(@RequestParam String answerUuid,
                                                   @RequestParam String userUuid) {
        return voteService.checkUserIsVotedOnAnswer(answerUuid, userUuid);
    }
}
