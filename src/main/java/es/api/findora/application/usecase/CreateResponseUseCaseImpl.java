package es.api.findora.application.usecase;

import es.api.findora.domain.exception.NotFoundException;
import es.api.findora.domain.exception.PersistenceException;
import es.api.findora.domain.exception.ValidationException;
import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.Response;
import es.api.findora.domain.model.User;
import es.api.findora.domain.port.in.CreateResponseUseCase;
import es.api.findora.domain.port.out.CommentRepository;
import es.api.findora.domain.port.out.PostRepository;
import es.api.findora.domain.port.out.ResponseRepository;
import es.api.findora.domain.port.out.UserRepository;
import es.api.findora.infrastructure.adapter.in.dto.comment.CreateCommentRequest;
import es.api.findora.infrastructure.adapter.in.dto.response.CreateResponseRequest;
import es.api.findora.infrastructure.adapter.in.dto.response.CreateResponseResponse;
import es.api.findora.infrastructure.adapter.in.dto.response.CreatedResponseData;
import es.api.findora.infrastructure.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateResponseUseCaseImpl implements CreateResponseUseCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ResponseRepository responseRepository;
    private final CommentMapper commentMapper;

    @Override
    public CreateResponseResponse execute(Long commentId, CreateResponseRequest request) {

        //Validations
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NotFoundException("El comentario asociado a la respuesta actual creada no existe"));

        User user = userRepository.findById(request.getUserId());
        if (user == null) {
            throw new NotFoundException("El usuario no existe");
        }

        if (request.getText() == null || request.getText().trim().isEmpty()) {
            throw new ValidationException("El comentario no puede estar vacío");
        }

        // Create response
        Response response = new Response();
        response.setComment(comment);
        response.setCreatedBy(user);
        response.setText(request.getText());
        response.setRate(request.getRate());
        response.setCreatedAt(LocalDateTime.now());
        response.setIsActive(true);

        // Save response
        Response savedResponse;
        try {
            savedResponse = responseRepository.save(response);
        } catch (Exception e) {
            throw new PersistenceException("Error al guardar la respuesta: " + e.getMessage());
        }

        //mapper
        CreatedResponseData data = commentMapper.toCreatedResponseData(savedResponse);

        CreateResponseResponse output = new CreateResponseResponse();
        output.setMessage("Respuesta a comentario creada exitosamente");
        output.setData(data);
        return output;
    }
}
