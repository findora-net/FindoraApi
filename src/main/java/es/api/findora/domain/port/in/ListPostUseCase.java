package es.api.findora.domain.port.in;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.Post;

import java.util.Optional;

public interface ListPostUseCase {

    PageModel<Post> execute(Integer pageKey, Integer pageSize);
}
