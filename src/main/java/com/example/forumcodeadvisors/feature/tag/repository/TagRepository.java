package com.example.forumcodeadvisors.feature.tag.repository;

import com.example.forumcodeadvisors.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
