package project.memories.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.memories.models.MemoriesUser;
import project.memories.models.Post;
import project.memories.models.PostLike;
import project.memories.repository.PostLikeRepository;
import project.memories.security.SecurityUtils;
import project.memories.services.PostLikeService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService {
    private final PostLikeRepository postLikeRepository;

    @Transactional
    @Override
    public long likePost(String postId) {
        String memoriesUserId = SecurityUtils.getCurrentMemoriesUser()
                .map(MemoriesUser::getUsername)
                .orElseThrow();
        Optional<PostLike> currentPostLike = postLikeRepository.findByPostAndAuthor(
                postId,
                memoriesUserId
        );

        if (currentPostLike.isPresent()) {
            postLikeRepository.delete(currentPostLike.get());
        } else {
            postLikeRepository.save(PostLike.builder()
                    .post(Post.builder()
                            .id(postId)
                            .build()
                    )
                    .author(MemoriesUser.builder()
                            .username(memoriesUserId)
                            .build())
                    .build()
            );
        }

        return postLikeRepository.count();
    }
}
