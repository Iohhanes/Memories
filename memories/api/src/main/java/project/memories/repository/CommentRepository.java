package project.memories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.memories.models.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
