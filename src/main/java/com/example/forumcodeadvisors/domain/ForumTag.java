package com.example.forumcodeadvisors.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "forum_tag")
@Setter
@Getter
@NoArgsConstructor
public class ForumTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String name;

    @ManyToMany
    private List<ForumContent> contents;


}
