package es.api.findora.infrastructure.adapter.in.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreatePostRequest {

    private String titlePost;
    private String description;
    private List<String> images;
    private List<String> links;
    private List<String> categories;
    private List<String> tags;
}
