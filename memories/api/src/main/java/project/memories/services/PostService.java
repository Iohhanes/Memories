package project.memories.services;

import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    List<Post> findAll(Pageable pageable);

    Post create(AddPostDto addPostDto);
}
