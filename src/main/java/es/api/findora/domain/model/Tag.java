package es.api.findora.domain.model;

import lombok.Data;

@Data
public class Tag {
    private Long id;
    private String name;
    private String type;
    private Integer value;
}
