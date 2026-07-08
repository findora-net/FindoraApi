package es.api.findora.infrastructure.adapter.in.dto.post;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import es.api.findora.infrastructure.adapter.in.dto.category.CategoryResponse;
import es.api.findora.infrastructure.adapter.in.dto.location.LocationResume;
import es.api.findora.infrastructure.adapter.in.dto.tag.TagResponse;
import es.api.findora.infrastructure.adapter.in.dto.user.UserResume;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<TagResponse> tags;
}
