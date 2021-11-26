package project.memories.mappers;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import project.memories.models.BaseMemoriesUserProperty;
import project.memories.models.dto.response.BaseMemoriesUserPropertyDto;

import java.util.List;

@MapperConfig(componentModel = "spring",
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface BaseUserPropertyMapper {

    @Mapping(target = "author", expression = "java(java.util.Optional.ofNullable(source.getAuthor()).map(project.memories.models.MemoriesUser::getUsername).orElse(null))")
    BaseMemoriesUserPropertyDto from(BaseMemoriesUserProperty source);

    List<BaseMemoriesUserPropertyDto> from(List<BaseMemoriesUserProperty> sources);
}
