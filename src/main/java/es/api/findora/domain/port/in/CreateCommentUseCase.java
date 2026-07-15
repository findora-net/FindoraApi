package es.api.findora.domain.port.in;

import es.api.findora.infrastructure.adapter.in.dto.comment.CreateCommentRequest;
import es.api.findora.infrastructure.adapter.in.dto.comment.CreateCommentResponse;

public interface CreateCommentUseCase {
    CreateCommentResponse execute(Long postId, CreateCommentRequest request);
}
