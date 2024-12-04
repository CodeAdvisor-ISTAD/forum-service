package com.example.forumcodeadvisors.feature.vote.repository;

import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByQuestionAndUserUuid(Question question, String userUuid);
}
