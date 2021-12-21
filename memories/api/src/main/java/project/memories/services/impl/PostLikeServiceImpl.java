package project.memories.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.memories.models.PostLike;
import project.memories.repository.PostLikeRepository;
import project.memories.services.PostLikeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService {
    private final PostLikeRepository postLikeRepository;

    @Override
    public List<PostLike> findByPost(String postId, int offset, int limit) {
        return postLikeRepository.findByPostId(postId, offset, limit);
    }
}
