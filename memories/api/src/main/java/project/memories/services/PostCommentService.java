package project.memories.services;

import project.memories.models.Comment;

public interface PostCommentService {
    void add(String postId, Comment comment);
}
