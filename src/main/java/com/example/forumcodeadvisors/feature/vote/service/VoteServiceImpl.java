package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.domain.Answer;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Vote;
import com.example.forumcodeadvisors.feature.answer.repository.AnswerRepository;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import com.example.forumcodeadvisors.feature.vote.dto.TotalVoteResponse;
import com.example.forumcodeadvisors.feature.vote.repository.VoteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoteServiceImpl implements VoteService{

    private final VoteRepository voteRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    /**
     * Vote for a question
     * @param questionUuid
     * @param userUuid
     * @return BaseResponse<?>
     */
    @Transactional
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
        for (Vote vote : votes) {
            if (vote.getUserUuid().equals(userUuid)) {
                throw new ResponseStatusException(
                        CONFLICT,
                        "User has already voted"
                );
            }
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

    /**
     * Get total votes for a question
     * @param questionUuid
     * @return TotalVoteResponse
     */
    @Override
    public TotalVoteResponse totalQuestionVotes(String questionUuid) {

        Question question = questionRepository.findByUuid(questionUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        List<Vote> upVote = voteRepository.findByQuestionAndIsUpvote(question, true);

        return TotalVoteResponse
                .builder()
                .totalVotes(upVote.size())
                .build();
    }

    /**
     * Vote for an answer
     * @param answerUuid
     * @param userUuid
     * @return BaseResponse<?>
     */
    @Override
    public BaseResponse<?> voteAnswer(String answerUuid, String userUuid) {

        // check if user is null
        if (userUuid == null) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "User UUID is required"
            );
        }

        // check if answer is null
        Answer answer = answerRepository.findByUuid(answerUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Answer not found"
                ));

        List<Vote> votes = answer.getVote();

        // check if user has already voted
        for (Vote vote : votes) {
            if (vote.getUserUuid().equals(userUuid)) {
                throw new ResponseStatusException(
                        CONFLICT,
                        "User has already voted"
                );
            }
        }

        Vote vote = new Vote();
        vote.setQuestion(answer.getQuestion());
        vote.setAnswer(answer);
        vote.setUserUuid(userUuid);
        vote.setUuid(UUID.randomUUID().toString());
        vote.setIsUpvote(true);
        voteRepository.save(vote);

        return null;
    }
}
