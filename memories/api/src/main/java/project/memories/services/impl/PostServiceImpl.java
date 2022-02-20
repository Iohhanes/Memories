package project.memories.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.memories.models.MemoriesUser;
import project.memories.models.Post;
import project.memories.repository.PostRepository;
import project.memories.security.SecurityUtils;
import project.memories.services.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> findAll(Pageable pageable) {
        String memoriesUserId = SecurityUtils.getCurrentMemoriesUser()
                .map(MemoriesUser::getUsername)
                .orElse("");
        return postRepository.findAllPosts(memoriesUserId, pageable);
    }

    @Override
    public Post add(Post addPost) {
        return postRepository.save(addPost);
    }
}
