package project.memories.models.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CommentDto extends BaseMemoriesUserPropertyDto {
    private String text;
    private int countOfLikes;
    private List<BaseMemoriesUserPropertyDto> likes;
}
