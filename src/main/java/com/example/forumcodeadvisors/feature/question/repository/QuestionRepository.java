package com.example.forumcodeadvisors.feature.question.repository;

import com.example.forumcodeadvisors.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    Optional<Question> findByUuid(String uuid);

    List<Question> findAllByIsArchivedAndIsDeletedAndIsDrafted(Boolean isArchived, Boolean isDeleted, Boolean isDrafted);

    Optional<Question> findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(String uuid, Boolean isArchived, Boolean isDeleted, Boolean isDrafted);

}
