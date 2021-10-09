package com.example.memories.services.impl;

import com.example.memories.mappers.AddPostRequestMapper;
import com.example.memories.models.Post;
import com.example.memories.models.dto.AddPostRequest;
import com.example.memories.repository.PostRepository;
import com.example.memories.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AddPostRequestMapper addPostRequestMapper;

    @Override
    public Post findById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable).getContent();
    }

    @Override
    public Post create(AddPostRequest addPostRequest) {
        Post newPost = addPostRequestMapper.from(addPostRequest);
        return postRepository.save(newPost);
    }
}
