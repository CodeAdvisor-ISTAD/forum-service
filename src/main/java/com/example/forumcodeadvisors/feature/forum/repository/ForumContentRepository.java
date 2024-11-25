package com.example.forumcodeadvisors.feature.forum.repository;

import com.example.forumcodeadvisors.domain.ForumContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumContentRepository extends JpaRepository<ForumContent,Long> {
}
