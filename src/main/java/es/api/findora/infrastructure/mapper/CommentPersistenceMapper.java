package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.Response;
import es.api.findora.infrastructure.persistence.entity.CommentEntity;
import es.api.findora.infrastructure.persistence.entity.ResponseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentPersistenceMapper {

    @Mapping(target = "userId", source = "commentOwner.id")
    @Mapping(target = "username", source = "commentOwner.username")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "date", source = "createdAt")
    @Mapping(target = "responses", source = "responses")
    Comment toDomain(CommentEntity entity);

    @Mapping(target = "userId", source = "responseOwner.id")
    @Mapping(target = "username", source = "responseOwner.username")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "date", source = "createdAt")
    Response toDomain(ResponseEntity entity);
}

