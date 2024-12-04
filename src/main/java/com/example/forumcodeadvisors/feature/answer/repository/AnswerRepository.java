package com.example.forumcodeadvisors.feature.answer.repository;

import com.example.forumcodeadvisors.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {

    Optional<Answer> findByUuid(String uuid);

    Answer findByUuidAndIsDeleted(String uuid, Boolean isDeleted);

    List<Answer> findAllByUuidAndIsDeleted(String uuid, Boolean isDeleted);

}
