package es.api.findora.domain.port.out;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.query.ListPostQuery;
import es.api.findora.domain.query.PaginationQuery;
import es.api.findora.domain.model.Post;

import java.util.Optional;

public interface PostRepository {

    PageModel<Post> list(PaginationQuery paginationQuery, ListPostQuery listPostQuery);
    Optional<Post> findById(Long id);

    boolean existsPost(Long id);
}
