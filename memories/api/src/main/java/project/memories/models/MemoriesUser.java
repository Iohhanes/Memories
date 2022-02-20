package project.memories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("mem_users")
@AllArgsConstructor
@Builder
public class MemoriesUser {
    @Id
    private String username;
    private String email;
    private String profile;
}
