package es.api.findora.infrastructure.adapter.in.dto.response;

import lombok.Data;

@Data
public class CreateResponseRequest {
    private Long userId;
    private Integer rate;
    private String text;
}

