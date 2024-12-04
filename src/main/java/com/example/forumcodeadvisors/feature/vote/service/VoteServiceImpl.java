package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Vote;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import com.example.forumcodeadvisors.feature.vote.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoteServiceImpl implements VoteService{

    private final VoteRepository voteRepository;
    private final QuestionRepository questionRepository;

    @Override
    public BaseResponse<?> voteQuestion(String voteUuid, String userUuid) {

        // check if user is null
        if (userUuid == null) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "User UUID is required"
            );
        }

        // find question by uuid
        Question question = questionRepository.findByUuid(voteUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        // check if user has already voted
        Vote vote = voteRepository.findByQuestionAndUserUuid(question, userUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "User has already voted"
                ));

        // if user has not voted, create a new vote
        if (vote == null) {
            vote = new Vote();
            vote.setQuestion(question);
            vote.setUserUuid(userUuid);
            vote.setIsUpvote(true);
            voteRepository.save(vote);
        }


        return null;
    }
}
