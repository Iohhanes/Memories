package com.example.memories.controllers;

import com.example.memories.models.Post;
import com.example.memories.models.dto.AddPostRequest;
import com.example.memories.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public Post findById(@PathVariable String id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<Post> findAll(@RequestParam int page, @RequestParam int size) {
        return postService.findAll(PageRequest.of(page, size));
    }

    @PostMapping("/create")
    public Post create(@RequestBody AddPostRequest addPostRequest) {
        return postService.create(addPostRequest);
    }
}
