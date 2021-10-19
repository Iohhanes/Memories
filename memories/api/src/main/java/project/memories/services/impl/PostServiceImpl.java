package project.memories.services.impl;

import project.memories.mappers.AddPostMapper;
import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import project.memories.repository.PostRepository;
import project.memories.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AddPostMapper addPostRequestMapper;

    @Override
    public Post findById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable).getContent();
    }

    @Override
    public Post create(AddPostDto addPostDto) {
        Post newPost = addPostRequestMapper.from(addPostDto);
        return postRepository.save(newPost);
    }
}
