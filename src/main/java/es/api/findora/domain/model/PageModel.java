package es.api.findora.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageModel<T> {
    private int pageKey;

    private int pageSize;

    private int totalPages;

    private long totalElements;

    private List<T> content;
}
