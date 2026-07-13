package es.api.findora.infrastructure.adapter.in.dto.post;

import es.api.findora.infrastructure.adapter.in.dto.PageRequest;
import lombok.Data;

import java.util.List;

@Data
public class ListPostRequest extends PageRequest {

    private Long userId;
    private List<Long> tags;
    private List<Long> categories;
    private Long location;
}
