package es.api.findora.infrastructure.adapter.in.dto;

import lombok.Data;

@Data
public class CommentResponse {
    private Long id;
    private Long post;
    private Long user;
    private String text;
    private String createdAt;
    private String createdBy;
    private Integer rate;
}
