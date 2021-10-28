package project.memories.mappers;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import project.memories.models.MemoriesUser;
import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import project.memories.services.MemoriesUserService;
import project.memories.services.StorageService;

@Mapper(componentModel = "spring")
public abstract class AddPostMapper {
    @Autowired
    private StorageService storageService;

    @Autowired
    private MemoriesUserService memoriesUserService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "description", source = "source.description")
    public abstract Post from(AddPostDto source);

    @AfterMapping
    protected void mapAuthor(@MappingTarget Post target, AddPostDto source) {
        if (source != null && StringUtils.hasLength(source.getAuthor())) {
            MemoriesUser memoriesUser = memoriesUserService.findByUsername(source.getAuthor());
            if (memoriesUser != null) {
                target.setAuthor(memoriesUser);
            }
        }
    }

    @AfterMapping
    protected void mapImages(@MappingTarget Post target, AddPostDto source) {
        if (source != null) {
            target.setImageFilenames(storageService.uploadFiles(source.getFiles()));
        }
    }
}
