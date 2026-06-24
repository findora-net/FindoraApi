package es.api.findora.domain.model;

import lombok.Data;

@Data
public class Image {
    private Integer num;
    private Post post;
    private String image;
}
