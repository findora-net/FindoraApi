package es.api.findora.infrastructure.adapter.in.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreatePostResponse {
    private Long id;
    private String nameLocation;
    private Double latitudeLocation;
    private Double longitudeLocation;
    private String titlePost;
    private String contentPost;
    private Integer rate;
    private String nameCategory;
    private List<String> images;
    private List<String> links;
}
