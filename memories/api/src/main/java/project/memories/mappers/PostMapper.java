package project.memories.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import project.memories.models.Post;
import project.memories.models.dto.response.PostDto;
import project.memories.services.StorageService;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
    @Autowired
    private StorageService storageService;

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "images", ignore = true)
    public abstract PostDto from(Post source);

    public abstract List<PostDto> from(List<Post> sources);

    @AfterMapping
    protected void mapAuthor(@MappingTarget PostDto target, Post source) {
        if (source != null && source.getAuthor() != null) {
            target.setAuthor(source.getAuthor().getUsername());
        }
    }

    @AfterMapping
    protected void mapImages(@MappingTarget PostDto target, Post source) {
        if (source != null && !CollectionUtils.isEmpty(source.getImageFilenames())) {
            target.setImages(source.getImageFilenames()
                    .stream()
                    .map(filename -> storageService.getPublicDownloadUrl(filename))
                    .collect(Collectors.toList()
                    )
            );
        }
    }
}
