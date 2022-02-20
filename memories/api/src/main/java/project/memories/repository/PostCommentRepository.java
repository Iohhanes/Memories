package project.memories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.memories.models.PostComment;

@Repository
public interface PostCommentRepository extends MongoRepository<PostComment, String> {
}
