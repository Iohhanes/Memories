package project.memories.mappers;

import org.mapstruct.Mapper;
import project.memories.models.CommentLike;
import project.memories.models.dto.response.BaseMemoriesUserPropertyDto;

import java.util.List;

@Mapper(componentModel = "spring",
        config = BaseUserPropertyMapper.class)
public interface CommentLikeMapper {

    BaseMemoriesUserPropertyDto from(CommentLike source);

    List<BaseMemoriesUserPropertyDto> from(List<CommentLike> sources);
}
