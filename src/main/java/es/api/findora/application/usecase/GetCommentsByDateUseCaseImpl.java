package es.api.findora.application.usecase;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.SortDirection;
import es.api.findora.domain.port.in.GetCommentsByDateUseCase;
import es.api.findora.domain.port.out.CommentRepository;

import java.util.List;

public class GetCommentsByDateUseCaseImpl implements GetCommentsByDateUseCase {

    private final CommentRepository commentRepository;

    public GetCommentsByDateUseCaseImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public List<Comment> execute(Long postId, SortDirection direction) {
        if(direction == null) {
            throw new IllegalArgumentException("Parámetro de ordenacion inválido. Debes usar ASC o DESC");
        }

        List<Comment> comments = commentRepository.getCommentsOrdered(postId, direction);

        if(comments.isEmpty() || comments == null) {
            throw new IllegalArgumentException("No se encontraron comentarios para el post con ID: " + postId);
        }

        return comments;
    }
}
