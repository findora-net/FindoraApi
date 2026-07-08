package es.api.findora.infrastructure.adapter.in.dto.post;

import lombok.Data;

@Data
public class CreatePostRequest {

    private Long idLocation;
    private String title;
    private String content;
    private Long idCategory;
    private Long idOwner;

}
