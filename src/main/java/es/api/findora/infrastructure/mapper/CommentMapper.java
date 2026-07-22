package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.Response;
import es.api.findora.infrastructure.adapter.in.dto.comment.CommentResponse;
import es.api.findora.infrastructure.adapter.in.dto.comment.CreatedCommentData;
import es.api.findora.infrastructure.adapter.in.dto.response.CreatedResponseData;
import es.api.findora.infrastructure.adapter.in.dto.response.ResponseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "user.id", source = "createdBy.id")
    @Mapping(target = "user.username", source = "createdBy.username")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "date", source = "createdAt")
    @Mapping(target = "responses", source = "responses")
    CommentResponse toCommentResponse(Comment comment);

    @Mapping(target = "user.id", source = "createdBy.id")
    @Mapping(target = "user.username", source = "createdBy.username")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "date", source = "createdAt")
    ResponseResponse toResponseResponse(Response response);

    // COMMENT → DTO SALIDA
    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "userId", source = "createdBy.id")
    @Mapping(target = "username", source = "createdBy.username")
    @Mapping(target = "date", expression = "java(comment.getCreatedAt().toString())")
    CreatedCommentData toCreatedCommentData(Comment comment);


    // RESPONSE → DTO SALIDA
    @Mapping(target = "commentId", source = "comment.id")
    @Mapping(target = "userId", source = "createdBy.id")
    @Mapping(target = "username", source = "createdBy.username")
    @Mapping(target = "date", expression = "java(response.getCreatedAt().toString())")
    CreatedResponseData toCreatedResponseData(Response response);

    List<ResponseResponse> toResponseResponseList(List<Response> responses);
}




