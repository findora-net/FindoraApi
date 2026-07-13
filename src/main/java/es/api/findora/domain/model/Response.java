package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {
    private Long id;
    private Long userId;
    private String username;
    private Integer rate;
    private String text;
    private LocalDateTime date;
}

