package project.memories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import project.memories.models.PostLike;

import java.util.Optional;

@Repository
public interface PostLikeRepository extends MongoRepository<PostLike, String> {
    @Query("{'post.$id' : ObjectId(?0), 'author.$id': ?1 }")
    Optional<PostLike> findByPostAndAuthor(String postId, String author);
}
