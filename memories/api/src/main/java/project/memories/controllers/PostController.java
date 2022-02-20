package project.memories.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.memories.mappers.request.AddCommentMapper;
import project.memories.mappers.request.AddPostMapper;
import project.memories.mappers.response.PostMapper;
import project.memories.models.Post;
import project.memories.models.dto.request.AddCommentDto;
import project.memories.models.dto.request.AddPostDto;
import project.memories.models.dto.response.PostDto;
import project.memories.services.PostCommentService;
import project.memories.services.PostLikeService;
import project.memories.services.PostService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static project.memories.constants.PageableConstants.DEFAULT_PAGE_INDEX;
import static project.memories.constants.PageableConstants.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final PostLikeService postLikeService;
    private final PostCommentService postCommentService;
    private final AddPostMapper addPostRequestMapper;
    private final AddCommentMapper addCommentRequestMapper;
    private final PostMapper postMapper;
    private final ObjectMapper objectMapper;

    @GetMapping
    public List<PostDto> findAll(@RequestParam(required = false) Integer page,
                                 @RequestParam(required = false) Integer size) {
        return postMapper.from(postService.findAll(PageRequest.of(
                Optional.ofNullable(page).orElse(DEFAULT_PAGE_INDEX),
                Optional.ofNullable(size).orElse(DEFAULT_PAGE_SIZE))
        ));

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestPart("requestBody") MultipartFile addPostDtoJson,
                                 @RequestPart(value = "images", required = false) List<MultipartFile> images) {
        AddPostDto addPostDto = new AddPostDto();
        try {
            if (addPostDtoJson != null && !addPostDtoJson.isEmpty()) {
                addPostDto = objectMapper.readValue(addPostDtoJson.getBytes(), AddPostDto.class);
            }
        } catch (IOException exception) {
            log.error("Error while reading json: {}", exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Request body is invalid");
        }

        addPostDto.setImages(images);
        Post post = postService.add(addPostRequestMapper.from(addPostDto));
        return ResponseEntity.status(HttpStatus.OK).body(postMapper.from(post));
    }

    @PostMapping("/{postId}/like")
    public long like(@PathVariable String postId) {
        return postLikeService.likePost(postId);
    }

    @PostMapping("/{postId}/comment")
    public void comment(@PathVariable String postId, @RequestBody AddCommentDto addCommentDto) {
        postCommentService.add(postId, addCommentRequestMapper.from(addCommentDto));
    }
}
