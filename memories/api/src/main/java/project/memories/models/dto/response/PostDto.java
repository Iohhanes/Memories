package project.memories.models.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private String id;
    private String description;
    private List<String> images;
    private boolean liked;
    private long countOfLikes;
    private long countOfComments;
    private AuthorDto author;
}
