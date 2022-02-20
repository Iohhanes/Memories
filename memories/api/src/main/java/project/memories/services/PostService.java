package project.memories.services;

import org.springframework.data.domain.Pageable;
import project.memories.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll(Pageable pageable);

    Post add(Post post);
}
