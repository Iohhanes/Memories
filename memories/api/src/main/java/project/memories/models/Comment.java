package project.memories.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("mem_comments")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class Comment extends BaseMemoriesUserProperty{
    private String text;
    @DBRef
    private Post post;
    private int countOfLikes;
    @Transient
    private List<CommentLike> likes;
}
