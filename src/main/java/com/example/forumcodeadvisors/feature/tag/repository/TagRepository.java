package com.example.forumcodeadvisors.feature.tag.repository;

import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.tag.dto.TagResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByNameIn(List<String> tagNames);

}
