package project.memories.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.memories.models.Comment;
import project.memories.models.Post;
import project.memories.models.PostComment;
import project.memories.repository.CommentRepository;
import project.memories.repository.PostCommentRepository;
import project.memories.security.SecurityUtils;
import project.memories.services.PostCommentService;

@Service
@RequiredArgsConstructor
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository postCommentRepository;
    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public void add(String postId, Comment commentRequest) {
        commentRepository.save(commentRequest);
        postCommentRepository.save(PostComment.builder()
                .post(Post.builder()
                        .id(postId)
                        .build()
                )
                .author(SecurityUtils.getCurrentMemoriesUser()
                        .orElseThrow())
                .build()
        );
    }
}
