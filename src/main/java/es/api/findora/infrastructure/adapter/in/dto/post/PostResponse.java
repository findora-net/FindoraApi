package es.api.findora.infrastructure.adapter.in.dto.post;


import es.api.findora.infrastructure.adapter.in.dto.category.CategoryResponse;
import es.api.findora.infrastructure.adapter.in.dto.location.LocationResume;
import es.api.findora.infrastructure.adapter.in.dto.user.UserResume;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private Long id;
    private LocationResume location;
    private String title;
    private String content;
    private Integer rate;
    private Boolean isActive;
    private CategoryResponse category;
    private LocalDateTime createdAt;
    private UserResume createdBy;
}
