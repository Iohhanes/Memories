package project.memories.services;

import project.memories.models.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findByPost(String postId, int offset, int limit);
}
