package es.api.findora.application.usecase;

import es.api.findora.domain.exception.NotFoundException;
import es.api.findora.domain.exception.PersistenceException;
import es.api.findora.domain.exception.ValidationException;
import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.model.User;
import es.api.findora.domain.port.in.CreateCommentUseCase;
import es.api.findora.domain.port.out.CommentRepository;
import es.api.findora.domain.port.out.PostRepository;
import es.api.findora.domain.port.out.UserRepository;
import es.api.findora.infrastructure.adapter.in.dto.comment.CreateCommentRequest;
import es.api.findora.infrastructure.adapter.in.dto.comment.CreateCommentResponse;
import es.api.findora.infrastructure.adapter.in.dto.comment.CreatedCommentData;
import es.api.findora.infrastructure.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateCommentUseCaseImpl implements CreateCommentUseCase {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public CreateCommentResponse execute(Long postId, CreateCommentRequest request) {

        //Validations
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException("La publicación no existe"));

        User user = userRepository.findById(request.getUserId());
        if (user == null) {
            throw new NotFoundException("El usuario no existe");
        }

        if (request.getText() == null || request.getText().trim().isEmpty()) {
            throw new ValidationException("El comentario no puede estar vacío");
        }

        // Create comment
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setCreatedBy(user);
        comment.setText(request.getText());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setRate(request.getRate());
        comment.setIsActive(true);

        // Save comment
        Comment savedComment;
        try {
            savedComment = commentRepository.save(comment);
        } catch (Exception e) {
            throw new PersistenceException("Error al guardar el comentario: " + e.getMessage());
        }

        //mapper
        CreatedCommentData data = commentMapper.toCreatedCommentData(savedComment);

        CreateCommentResponse response = new CreateCommentResponse();
        response.setMessage("Comentario creado exitosamente");
        response.setData(data);
        return response;
    }
}
