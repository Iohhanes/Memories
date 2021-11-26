package project.memories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import project.memories.models.PostLike;

import java.util.List;

@Repository
public interface PostLikeRepository extends MongoRepository<PostLike, String> {
    @Query("db.mem_post_likes.find({ query: { 'post' : ?0}).limit(?2).skip(?1)")
    List<PostLike> findByPostId(String postId, int offset, int limit);
}
