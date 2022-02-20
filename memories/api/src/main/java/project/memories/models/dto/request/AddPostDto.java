package project.memories.models.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AddPostDto {
    private String description;
    List<MultipartFile> images;
}
