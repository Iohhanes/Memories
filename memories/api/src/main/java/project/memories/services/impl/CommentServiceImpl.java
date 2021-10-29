package project.memories.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.memories.models.Comment;
import project.memories.repository.CommentRepository;
import project.memories.services.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findByPost(String postId, int offset, int limit) {
        return commentRepository.findByPostId(postId, offset, limit);
    }
}
