package project.memories.mappers;

import org.mapstruct.Mapper;
import project.memories.models.PostLike;
import project.memories.models.dto.response.BaseMemoriesUserPropertyDto;

import java.util.List;

@Mapper(componentModel = "spring",
        config = BaseUserPropertyMapper.class)
public interface PostLikeMapper {

    BaseMemoriesUserPropertyDto from(PostLike source);

    List<BaseMemoriesUserPropertyDto> from(List<PostLike> sources);
}
