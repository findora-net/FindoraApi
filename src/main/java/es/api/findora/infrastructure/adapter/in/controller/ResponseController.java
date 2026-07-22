package es.api.findora.infrastructure.adapter.in.controller;

import es.api.findora.domain.port.in.CreateResponseUseCase;
import es.api.findora.infrastructure.adapter.in.dto.response.CreateResponseRequest;
import es.api.findora.infrastructure.adapter.in.dto.response.CreateResponseResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responses")
@AllArgsConstructor
public class ResponseController {
    private final CreateResponseUseCase createResponseUseCase;

    @PostMapping("/{commentId}/create")
    public ResponseEntity<CreateResponseResponse> createResponse(@PathVariable Long commentId, @RequestBody CreateResponseRequest request) {
        CreateResponseResponse response = createResponseUseCase.execute(commentId, request);
        return ResponseEntity.ok(response);
    }
}
