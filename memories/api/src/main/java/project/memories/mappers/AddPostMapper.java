package project.memories.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import project.memories.models.Post;
import project.memories.models.dto.request.AddPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.memories.services.StorageService;

@Mapper(componentModel = "spring")
public abstract class AddPostMapper {
    @Autowired
    private StorageService storageService;

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    public abstract Post from(AddPostDto source);

    @AfterMapping
    protected void mapImages(@MappingTarget Post target, AddPostDto source) {
        if (source != null) {
            target.setImageFilenames(storageService.uploadFiles(source.getFiles()));
        }
    }
}
