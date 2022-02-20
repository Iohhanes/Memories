package project.memories.mappers.request;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import project.memories.mappers.BaseMemoriesUserPropertyMapper;
import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import project.memories.services.StorageService;

@Mapper(
        componentModel = "spring",
        config = BaseMemoriesUserPropertyMapper.class
)
public abstract class AddPostMapper {
    @Autowired
    private StorageService storageService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "description", source = "source.description")
    public abstract Post from(AddPostDto source);

    @AfterMapping
    protected void mapImages(@MappingTarget Post target, AddPostDto source) {
        if (source != null) {
            target.setImages(storageService.uploadFiles(source.getImages()));
        }
    }
}
