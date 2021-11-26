package project.memories.services.impl;

import project.memories.mappers.AddPostMapper;
import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import project.memories.repository.PostRepository;
import project.memories.services.CommentService;
import project.memories.services.PostLikeService;
import project.memories.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static project.memories.constants.PageableConstants.*;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostLikeService postLikeService;
    private final CommentService commentService;
    private final AddPostMapper addPostRequestMapper;

    @Override
    public List<Post> findAll(Pageable pageable) {
        List<Post> posts = postRepository.findAll(pageable).getContent();
        posts.forEach(post -> {
                    post.setLikes(postLikeService.findByPost(post.getId(), DEFAULT_SEARCH_OFFSET, DEFAULT_SEARCH_LIMIT));
                    post.setComments(commentService.findByPost(post.getId(), DEFAULT_SEARCH_OFFSET, DEFAULT_SEARCH_LIMIT));
                }
        );
        return posts;
    }

    @Override
    public Post create(AddPostDto addPostDto) {
        Post newPost = addPostRequestMapper.from(addPostDto);
        return postRepository.save(newPost);
    }
}
