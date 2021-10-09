package com.example.memories.services;

import com.example.memories.models.Post;
import com.example.memories.models.dto.AddPostRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Post findById(String id);

    List<Post> findAll(Pageable pageable);

    Post create(AddPostRequest addPostRequest);
}
