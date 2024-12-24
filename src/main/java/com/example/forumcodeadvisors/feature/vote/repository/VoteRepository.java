package com.example.forumcodeadvisors.feature.vote.repository;

import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Vote findByUserUuid(String userUuid);

    Boolean existsByQuestionUuidAndUserUuid(String questionUuid, String userUuid);

    Integer countByQuestion(Question question);

    List<Vote> findByQuestionAndIsUpvote(Question question, Boolean isUpvote);
}
