package es.api.findora.application.usecase;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.query.PaginationQuery;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.in.ListPostUseCase;
import es.api.findora.domain.port.out.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListPostUseCaseImpl implements ListPostUseCase {

    private final PostRepository postRepository;

    private final int DEFAULT_PAGEKEY = 0;
    private final int DEFAULT_PAGESIZE = 10;
    private final String DEFAULT_ORDERBY = "rate";

    @Override
    public PageModel<Post> execute(Integer pageKey, Integer pageSize) {

        PaginationQuery paginationQuery = new PaginationQuery(
                processPageKey(pageKey),
                processPageSize(pageSize),
                false,
                DEFAULT_ORDERBY
        );
        return postRepository.list(paginationQuery);
    }

    public int processPageKey(Integer pageKey){
        int result = DEFAULT_PAGEKEY;

        if(pageKey != null){
            result = pageKey;
        }

        return result;
    }

    public int processPageSize(Integer pageSize){
        int result = DEFAULT_PAGESIZE;

        if(pageSize != null){
            result = pageSize;
        }

        return result;
    }
}
