package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.Response;
import es.api.findora.infrastructure.persistence.entity.CommentEntity;
import es.api.findora.infrastructure.persistence.entity.ResponseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentPersistenceMapper {

    // COMMENT
    @Mapping(target = "post", ignore = true) // no lo necesitamos en US27
    @Mapping(target = "createdBy", source = "commentOwner")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "isActive", source = "isActive")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "responses", source = "responses")   // ✔ ahora sí
    Comment toDomain(CommentEntity entity);

    // RESPONSE
    @Mapping(target = "comment", ignore = true)            // rompe el ciclo
    @Mapping(target = "createdBy", source = "responseOwner")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "isActive", source = "isActive")
    @Mapping(target = "rate", source = "rate")
    Response toDomain(ResponseEntity entity);
}




