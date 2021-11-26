package project.memories.mappers;

import org.mapstruct.Mapper;
import project.memories.models.Comment;
import project.memories.models.dto.response.CommentDto;

import java.util.List;

@Mapper(componentModel = "spring",
        config = BaseUserPropertyMapper.class,
        uses = CommentLikeMapper.class)
public interface CommentMapper {

    CommentDto from(Comment source);

    List<CommentDto> from(List<Comment> sources);
}
