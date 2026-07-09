package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.Response;
import es.api.findora.infrastructure.adapter.in.dto.CommentResponse;
import es.api.findora.infrastructure.adapter.in.dto.ResponseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "date", source = "date")
    CommentResponse toCommentResponse(Comment comment);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "date", source = "date")
    ResponseResponse toResponseResponse(Response response);

    List<ResponseResponse> toResponseResponseList(List<Response> responses);
}


