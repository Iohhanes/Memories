package project.memories.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import project.memories.models.BaseMemoriesUserProperty;
import project.memories.models.MemoriesUser;
import project.memories.models.dto.response.AuthorDto;
import project.memories.models.dto.response.BaseMemoriesUserPropertyResponseDto;

@MapperConfig(
        componentModel = "spring",
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG
)
public interface BaseMemoriesUserPropertyMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "author", expression = "java(from(source.getAuthor()))")
    BaseMemoriesUserPropertyResponseDto from(BaseMemoriesUserProperty source);

    AuthorDto from(MemoriesUser source);
}
