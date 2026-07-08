package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post {
    private Long id;
    private Location location;
    private String title;
    private String content;
    private Integer rate;
    private Boolean isActive;
    private Category category;
    private LocalDateTime createdAt;
    private User createdBy;
    private List<Tag> tags;
}
