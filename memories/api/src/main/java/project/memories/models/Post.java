package project.memories.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("mem_posts")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class Post extends BaseMemoriesUserProperty {
    private String description;
    private List<String> images;
    private boolean liked;
    private Long countOfLikes;
    private Long countOfComments;
}
