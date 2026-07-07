package es.api.findora.domain.port.out;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.PaginationRequest;
import es.api.findora.domain.model.Post;

public interface PostRepository {

    PageModel<Post> list(PaginationRequest paginationRequest);
}
