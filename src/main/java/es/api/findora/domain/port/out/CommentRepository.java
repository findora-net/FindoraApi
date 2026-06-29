package es.api.findora.domain.port.out;

import es.api.findora.domain.model.Category;
import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.SortDirection;

import java.util.List;

public interface CommentRepository {
    List<Comment> getCommentsOrdered(Long postId, SortDirection sortDirection);
}
