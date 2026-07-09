package es.api.findora.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationRequest {

    private int pageNumber;
    private int pageSize;
    private boolean isAsc;
    private String sortBy;

}
