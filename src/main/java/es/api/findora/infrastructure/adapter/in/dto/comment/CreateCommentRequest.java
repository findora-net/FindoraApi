package es.api.findora.infrastructure.adapter.in.dto.comment;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private Long userId;
    private Integer rate;
    private String text;
}

