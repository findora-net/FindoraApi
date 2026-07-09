package es.api.findora.application.usecase;

import es.api.findora.domain.exception.NotFoundException;
import es.api.findora.domain.exception.ValidationException;
import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.SortDirection;
import es.api.findora.domain.port.in.GetCommentsByDateUseCase;
import es.api.findora.domain.port.out.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetCommentsByDateUseCaseImpl implements GetCommentsByDateUseCase {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> execute(Long commentedPost, SortDirection direction) {
        return this.commentRepository.getCommentsOrdered(commentedPost, direction);
    }

}
