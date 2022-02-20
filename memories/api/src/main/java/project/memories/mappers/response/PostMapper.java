package project.memories.mappers.response;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import project.memories.mappers.BaseMemoriesUserPropertyMapper;
import project.memories.models.Post;
import project.memories.models.dto.response.PostDto;
import project.memories.services.StorageService;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        config = BaseMemoriesUserPropertyMapper.class
)
public abstract class PostMapper {
    @Autowired
    private StorageService storageService;

    @Mapping(target = "images", ignore = true)
    @Mapping(target = "countOfLikes", expression = "java(java.util.Optional.ofNullable(source.getCountOfLikes()).orElse(0L))")
    @Mapping(target = "countOfComments", expression = "java(java.util.Optional.ofNullable(source.getCountOfComments()).orElse(0L))")
    public abstract PostDto from(Post source);

    public abstract List<PostDto> from(List<Post> sources);

    @AfterMapping
    protected void mapImages(@MappingTarget PostDto target, Post source) {
        if (source != null && !CollectionUtils.isEmpty(source.getImages())) {
            target.setImages(source.getImages()
                    .stream()
                    .map(filename -> storageService.getPublicDownloadUrl(filename))
                    .collect(Collectors.toList()
                    )
            );
        }
    }
}
