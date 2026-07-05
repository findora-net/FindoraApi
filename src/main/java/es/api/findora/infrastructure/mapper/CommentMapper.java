package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Comment;
import es.api.findora.infrastructure.adapter.in.dto.CommentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentResponse toCommentResponse(Comment comment);
}
