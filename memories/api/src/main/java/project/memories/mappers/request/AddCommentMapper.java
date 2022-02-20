package project.memories.mappers.request;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.memories.mappers.BaseMemoriesUserPropertyMapper;
import project.memories.models.Comment;
import project.memories.models.dto.request.AddCommentDto;

@Mapper(
        componentModel = "spring",
        config = BaseMemoriesUserPropertyMapper.class
)
public interface  AddCommentMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "text", source = "source.text")
    Comment from(AddCommentDto source);
}
