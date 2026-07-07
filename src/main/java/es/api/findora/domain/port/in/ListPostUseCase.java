package es.api.findora.domain.port.in;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.Post;

public interface ListPostUseCase {

    PageModel<Post> execute();
}
