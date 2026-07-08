package es.api.findora.infrastructure.adapter.in.dto.tag;

import lombok.Data;

@Data
public class TagResponse {
    private Long id;
    private String name;
    private String type;
    private Integer value;
}
