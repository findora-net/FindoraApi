package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {
    private Long id;
    private Comment comment;
    private User createdBy;
    private String text;
    private LocalDateTime createdAt;
    private Boolean isActive;
    private Integer rate;
}
