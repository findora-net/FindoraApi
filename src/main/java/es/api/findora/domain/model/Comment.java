package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private Post post;
    private String text;
    private LocalDateTime createdAt;
    private User createdBy;
    private Boolean isActive;
    private Integer rate;

}
