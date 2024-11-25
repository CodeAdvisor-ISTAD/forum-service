package com.example.forumcodeadvisors.domain;

import com.example.forumcodeadvisors.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "forum_content")
@Setter
@Getter
@NoArgsConstructor
public class ForumContent extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String authorId;

    private String interactionId;

    @ManyToMany
    @JoinTable(
            name = "forum_content_tag",
            joinColumns = @JoinColumn(name = "forum_content_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_tag_id")
    )
    private List<ForumTag> tags;



}
