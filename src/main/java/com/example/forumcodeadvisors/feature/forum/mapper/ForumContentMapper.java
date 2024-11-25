package com.example.forumcodeadvisors.feature.forum.mapper;

import com.example.forumcodeadvisors.domain.ForumContent;
import com.example.forumcodeadvisors.domain.ForumTag;
import com.example.forumcodeadvisors.feature.forum.dto.CreateForumRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ForumContentMapper {

    @Mapping(source = "tags", target = "tags", qualifiedByName = "mapTags")
    ForumContent fromCreateForumRequest(CreateForumRequest createForumRequest);

    @Named("mapTags")
    default List<ForumTag> mapTags(List<String> tags) {
        return tags.stream()
                .map(this::mapTag)
                .collect(Collectors.toList());
    }

    default ForumTag mapTag(String tagName) {
        ForumTag tag = new ForumTag();
        tag.setName(tagName);
        return tag;
    }

}
