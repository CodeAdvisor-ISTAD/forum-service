package com.example.forumcodeadvisors.feature.vote.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@Setter
@Getter
@RequestMapping("/api/v1/votes")
@RequiredArgsConstructor
public class VoteController {
}
