package es.api.findora.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationQuery {

    private int pageKey;
    private int pageSize;
    private boolean isAsc;
    private String sortBy;

    public int getFirstResult(){
        return pageKey * pageSize;
    }

    public int getTotalPages(long totalElements){
        return (int) Math.ceil((double) totalElements / pageSize);
    }
}
