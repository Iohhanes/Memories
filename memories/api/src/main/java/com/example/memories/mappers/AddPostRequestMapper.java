package com.example.memories.mappers;

import com.example.memories.models.Post;
import com.example.memories.models.dto.AddPostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddPostRequestMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Post from(AddPostRequest addPostRequest);
}
