package es.api.findora.infrastructure.adapter.in.dto.response;

import lombok.Data;

@Data
public class CreateResponseResponse {
    private String message;
    private CreatedResponseData data;
}
