package project.memories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.memories.models.MemoriesUser;

import java.util.Optional;

@Repository
public interface MemoriesUserRepository extends MongoRepository<MemoriesUser, String> {
    Optional<MemoriesUser> findByUsername(String username);
}
