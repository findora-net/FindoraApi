package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Tag;
import es.api.findora.infrastructure.adapter.in.dto.tag.TagResponse;
import es.api.findora.infrastructure.persistence.entity.TagEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag toModel(TagEntity tagEntity);

    TagResponse toResponse(Tag tag);
}
