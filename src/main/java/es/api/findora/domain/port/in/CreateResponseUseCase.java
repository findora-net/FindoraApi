package es.api.findora.domain.port.in;

import es.api.findora.infrastructure.adapter.in.dto.response.CreateResponseRequest;
import es.api.findora.infrastructure.adapter.in.dto.response.CreateResponseResponse;

public interface CreateResponseUseCase {
    CreateResponseResponse execute(Long commentId, CreateResponseRequest request);
}
