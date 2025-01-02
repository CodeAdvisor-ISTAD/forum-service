package com.example.forumcodeadvisors.feature.answer.mapper;

import com.example.forumcodeadvisors.domain.Answer;
import com.example.forumcodeadvisors.feature.answer.dto.AnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(target = "question.uuid", source = "questionUuid")
    Answer fromCreateAnswerRequest(CreateAnswerRequest createAnswerRequest);

    @Mapping(target = "questionUuid", source = "question.uuid")
    ParentAnswerResponse toParentAnswerResponse(Answer answer);

    default List<AnswerResponse> answerListToAnswerResponseList(List<Answer> answers) {
        if (answers == null) {
            return null;
        }
        return answers.stream()
                .map(this::answerToAnswerResponse)
                .filter(response -> response != null)
                .toList();
    }

    @Mapping(target = "questionUuid", source = "question.uuid")
    default AnswerResponse answerToAnswerResponse(Answer answer) {
        if (answer == null || Boolean.TRUE.equals(answer.getIsDeleted())) {
            return null;
        }
        return mapNonDeletedAnswer(answer);
    }

    @Mapping(target = "questionUuid", source = "question.uuid")
    AnswerResponse mapNonDeletedAnswer(Answer answer);



}
