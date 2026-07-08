package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.PaginationRequest;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.out.PostRepository;
import es.api.findora.infrastructure.mapper.PostMapper;
import es.api.findora.infrastructure.persistence.entity.PostEntity;
import es.api.findora.infrastructure.persistence.repository.PostRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostRepositoryJPA postRepositoryJPA;
    private final PostMapper postMapper;

    @Override
    public PageModel<Post> list(PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(
                paginationRequest.getPageNumber(),
                paginationRequest.getPageSize(),
                Sort.by(
                        paginationRequest.isAsc() ?
                                Sort.Direction.ASC :
                                Sort.Direction.DESC,
                        paginationRequest.getSortBy())
        );

        Page<PostEntity> page = postRepositoryJPA.findAll(pageable);
        return postMapper.toPageModel(page);
    }
}
