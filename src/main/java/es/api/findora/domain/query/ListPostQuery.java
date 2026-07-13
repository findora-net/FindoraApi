package es.api.findora.domain.query;

import lombok.Data;

import java.util.List;

@Data
public class ListPostQuery {

    private Long userId;
    private List<Long> tags;
    private List<Long> categories;
    private Long location;
}
