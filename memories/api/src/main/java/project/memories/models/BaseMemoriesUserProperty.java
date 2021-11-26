package project.memories.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@SuperBuilder
@NoArgsConstructor
public class BaseMemoriesUserProperty {
    @Id
    private String id;
    @DBRef
    private MemoriesUser author;
}
