package es.api.findora.domain.port.out;

import es.api.findora.domain.model.Category;
import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.SortDirection;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    boolean existsPost(Long postId);
    List<Comment> getCommentsOrdered(Long postId, SortDirection direction);
    Optional<Comment> findById(Long id);

    Comment save(Comment comment);
}
