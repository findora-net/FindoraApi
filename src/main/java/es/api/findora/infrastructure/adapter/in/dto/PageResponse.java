package es.api.findora.infrastructure.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import es.api.findora.domain.model.PageModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder({"pageKey", "pageSize", "totalElements", "totalPages", "content"})
@AllArgsConstructor
public class PageResponse <T>{

    private int pageKey;

    private int pageSize;

    private int totalPages;

    private long totalElements;

    private List<T> content;
}
