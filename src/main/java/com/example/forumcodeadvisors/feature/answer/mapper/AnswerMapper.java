package com.example.forumcodeadvisors.feature.answer.mapper;

import com.example.forumcodeadvisors.domain.Answer;
import com.example.forumcodeadvisors.feature.answer.dto.AnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    Answer fromCreateAnswerRequest(CreateAnswerRequest createAnswerRequest);

    ParentAnswerResponse toParentAnswerResponse(Answer answer);

    AnswerResponse toAnswerResponse(Answer answer);
}
