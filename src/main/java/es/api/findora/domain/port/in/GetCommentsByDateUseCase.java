package es.api.findora.domain.port.in;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.SortDirection;

import java.util.List;

public interface GetCommentsByDateUseCase {
    List<Comment> execute(Long commentedPost, SortDirection direction);
}
