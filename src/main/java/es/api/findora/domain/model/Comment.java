package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Comment {
    private Long id;
    private Long userId;
    private String username;
    private Integer rate;
    private String text;
    private LocalDateTime date;
    private List<Response> responses;
}
