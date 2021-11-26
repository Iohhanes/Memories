package project.memories.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.memories.mappers.PostMapper;
import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import project.memories.models.dto.response.PostDto;
import project.memories.services.PostService;
import project.memories.utils.JsonMappingUtils;

import java.util.List;
import java.util.Optional;

import static project.memories.constants.PageableConstants.DEFAULT_PAGE_INDEX;
import static project.memories.constants.PageableConstants.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;
    private final JsonMappingUtils jsonMappingUtils;

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
    public ResponseEntity<?> create(@RequestPart("request") MultipartFile addPostDtoJson,
                                    @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        AddPostDto addPostDto = jsonMappingUtils.readObjectFromMultiPart(addPostDtoJson, AddPostDto.class);
        if (addPostDto == null) {
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Post request is invalid");
        }
        addPostDto.setFiles(files);
        Post post = postService.create(addPostDto);
        return ResponseEntity.status(HttpStatus.OK).body(postMapper.from(post));
    }
}
