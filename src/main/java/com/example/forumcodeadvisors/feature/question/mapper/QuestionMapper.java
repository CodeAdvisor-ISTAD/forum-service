package com.example.forumcodeadvisors.feature.question.mapper;

import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionResponse toQuestionResponse(Question question);

    List<QuestionResponse> toQuestionResponse(List<Question> questions);

    @Mapping(source = "tagIds", target = "tags", qualifiedByName = "mapTagIds")
    Question fromCreateQuestionRequest(CreateQuestionRequest createForumRequest);

    @Named("mapTagIds")
    default List<Tag> mapTagIds(List<Long> tagIds) {
        return tagIds.stream()
                .map(this::mapTagId)
                .collect(Collectors.toList());
    }

    default Tag mapTagId(Long id) {
        Tag tag = new Tag();
        tag.setId(id);
        return tag;
    }

}
