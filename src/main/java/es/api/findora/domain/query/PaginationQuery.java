package es.api.findora.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationQuery {

    private int pageNumber;
    private int pageSize;
    private boolean isAsc;
    private String sortBy;

}
