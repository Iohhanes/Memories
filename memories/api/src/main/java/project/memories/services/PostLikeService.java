package project.memories.services;

import project.memories.models.PostLike;

import java.util.List;

public interface PostLikeService {
    List<PostLike> findByPost(String postId, int offset, int limit);
}
