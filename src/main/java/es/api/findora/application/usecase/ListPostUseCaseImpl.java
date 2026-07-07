package es.api.findora.application.usecase;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.PaginationRequest;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.in.ListPostUseCase;
import es.api.findora.domain.port.out.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListPostUseCaseImpl implements ListPostUseCase {

    private final PostRepository postRepository;

    @Override
    public PageModel<Post> execute() {
        PaginationRequest paginationRequest = new PaginationRequest(
                0,
                10,
                false,
                "id"
        );
        return postRepository.list(paginationRequest);
    }
}
