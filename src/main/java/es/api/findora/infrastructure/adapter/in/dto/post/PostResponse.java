package es.api.findora.infrastructure.adapter.in.dto.post;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import es.api.findora.infrastructure.adapter.in.dto.category.CategoryResponse;
import es.api.findora.infrastructure.adapter.in.dto.location.LocationResume;
import es.api.findora.infrastructure.adapter.in.dto.user.UserResume;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({"id", "location", "title", "content", "rate", "isActive", "category", "createdAt", "createdBy"})
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
