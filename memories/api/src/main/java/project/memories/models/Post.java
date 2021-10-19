package project.memories.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("mem_posts")
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private String description;
    private String author;
    private List<String> imageFilenames;
}
