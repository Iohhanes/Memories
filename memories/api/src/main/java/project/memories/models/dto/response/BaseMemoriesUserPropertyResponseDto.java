package project.memories.models.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseMemoriesUserPropertyResponseDto {
    private String id;
    private AuthorDto author;
}
