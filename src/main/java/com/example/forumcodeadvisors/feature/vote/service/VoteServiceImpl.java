package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Vote;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import com.example.forumcodeadvisors.feature.vote.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoteServiceImpl implements VoteService{

    private final VoteRepository voteRepository;
    private final QuestionRepository questionRepository;

    @Override
    public BaseResponse<?> voteQuestion(String questionUuid, String userUuid) {

        // check if user is null
        if (userUuid == null) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "User UUID is required"
            );
        }

        Question question = questionRepository.findByUuid(questionUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        List<Vote> votes = question.getVote();

        // check if user has already voted
        if (votes.stream().anyMatch(vote -> vote.getUserUuid().equals(userUuid))) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "User has already voted"
            );
        }

        Vote vote = new Vote();
        vote.setQuestion(question);
        vote.setUserUuid(userUuid);
        vote.setUuid(UUID.randomUUID().toString());
        vote.setIsUpvote(true);
        voteRepository.save(vote);



        return BaseResponse
                .builder()
                .code(HttpStatus.CREATED.value())
                .message("Vote successful")
                .build();
    }

    @Override
    public Integer totalQuestionVotes(String questionUuid) {

        Question question = questionRepository.findByUuid(questionUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        return voteRepository.countByQuestion(question);
    }
}
