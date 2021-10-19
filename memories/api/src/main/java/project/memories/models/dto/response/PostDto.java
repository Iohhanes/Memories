package project.memories.models.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private String id;
    private String description;
    private String author;
    private List<String> images;
}
