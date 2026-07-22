package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.model.Response;
import es.api.findora.domain.model.User;
import es.api.findora.infrastructure.persistence.entity.CommentEntity;
import es.api.findora.infrastructure.persistence.entity.PostEntity;
import es.api.findora.infrastructure.persistence.entity.ResponseEntity;
import es.api.findora.infrastructure.persistence.entity.UserEntity;
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


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "image", source = "image")
    @Mapping(target = "birthdate", expression = "java(entity.getBirthdate() != null ? entity.getBirthdate().toLocalDate() : null)")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "point", source = "point")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createdAt", source = "createdAt")
    User toDomain(UserEntity entity);


    // POST ENTITY → DOMAIN
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    Post toDomain(PostEntity entity);


    CommentEntity toEntity(Comment comment);

    ResponseEntity toEntity(Response response);
}




