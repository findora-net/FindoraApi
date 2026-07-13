package es.api.findora.application.usecase;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.query.ListPostQuery;
import es.api.findora.domain.query.PaginationQuery;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.in.ListPostUseCase;
import es.api.findora.domain.port.out.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListPostUseCaseImpl implements ListPostUseCase {

    private final String DEFAULT_SORTBY = "rate";
    private final PostRepository postRepository;


    @Override
    public PageModel<Post> execute(PaginationQuery paginationQuery, ListPostQuery listPostQuery) {

        if(paginationQuery.getSortBy() == null || paginationQuery.getSortBy().isBlank()){
            paginationQuery.setSortBy(DEFAULT_SORTBY);
        }

        return postRepository.list(paginationQuery,listPostQuery);
    }
}
