package es.api.findora.infrastructure.adapter.in.dto;

import es.api.findora.domain.query.PaginationQuery;
import lombok.Data;


@Data
public class PageRequest {
    private Integer pageKey;
    private Integer pageSize;
    private String sortBy;
    private String orderBy;

    private final int DEFAULT_PAGEKEY = 0;
    private final int DEFAULT_PAGESIZE = 10;

    public PaginationQuery buildPaginationQuery(){
        PaginationQuery paginationQuery = new PaginationQuery();

        if(this.pageKey == null){
            paginationQuery.setPageKey(DEFAULT_PAGEKEY);
        }else{
            paginationQuery.setPageKey(this.pageKey);
        }

        if(this.pageSize == null){
            paginationQuery.setPageSize(DEFAULT_PAGESIZE);
        }else{
            paginationQuery.setPageSize(this.pageSize);
        }

        paginationQuery.setSortBy(this.sortBy);

        paginationQuery.setAsc(this.orderBy == "ASC");

        return paginationQuery;
    }
}
