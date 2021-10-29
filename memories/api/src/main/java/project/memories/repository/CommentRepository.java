package project.memories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import project.memories.models.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    @Query("db.mem_comments.find({ query: { 'post' : ?0}).limit(?2).skip(?1)")
    List<Comment> findByPostId(String postId, int offset, int limit);
}
