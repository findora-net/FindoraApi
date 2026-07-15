package es.api.findora.infrastructure.adapter.in.dto.comment;

import lombok.Data;

@Data
public class CreateCommentResponse {
    private String message;          // mensaje de éxito o error
    private CreatedCommentData data; // datos del comentario creado
}

