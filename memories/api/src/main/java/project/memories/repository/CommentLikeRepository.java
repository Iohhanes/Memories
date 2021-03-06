package project.memories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.memories.models.CommentLike;

@Repository
public interface CommentLikeRepository extends MongoRepository<CommentLike, String> {
}
