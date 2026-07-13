package es.api.findora.domain.port.in;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.query.ListPostQuery;
import es.api.findora.domain.query.PaginationQuery;

import java.util.Optional;

public interface ListPostUseCase {

    PageModel<Post> execute(PaginationQuery paginationQuery, ListPostQuery listPostQuery);
}
