package project.memories.models.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PostDto extends BaseMemoriesUserPropertyDto {
    private String description;
    private List<String> images;
    private List<CommentDto> comments;
    private int countOfLikes;
    private List<BaseMemoriesUserPropertyDto> likes;
}
