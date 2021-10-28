package project.memories.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;
import project.memories.mappers.PostMapper;
import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import project.memories.models.dto.response.PostDto;
import project.memories.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static project.memories.constants.PageableConstants.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;
    private final ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public PostDto findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return postMapper.from(post);
    }

    @GetMapping
    public List<PostDto> findAll(@RequestParam(required = false) Integer page,
                                 @RequestParam(required = false) Integer size) {
        List<Post> posts = postService.findAll(PageRequest.of(
                Optional.ofNullable(page).orElse(DEFAULT_PAGE_INDEX),
                Optional.ofNullable(size).orElse(DEFAULT_PAGE_SIZE))
        );
        return postMapper.from(posts);
    }

    @PostMapping("/create")
    public PostDto create(@RequestPart("request") MultipartFile addPostDtoJson,
                          @RequestPart(value = "files", required = false) List<MultipartFile> files) throws IOException {
        AddPostDto addPostDto = objectMapper.readValue(addPostDtoJson.getBytes(), AddPostDto.class);
        addPostDto.setFiles(files);
        Post post = postService.create(addPostDto);
        return postMapper.from(post);
    }
}
