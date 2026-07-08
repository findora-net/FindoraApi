package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.query.PaginationQuery;
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
    public PageModel<Post> list(PaginationQuery paginationQuery) {
        Pageable pageable = PageRequest.of(
                paginationQuery.getPageNumber(),
                paginationQuery.getPageSize(),
                Sort.by(
                        paginationQuery.isAsc() ?
                                Sort.Direction.ASC :
                                Sort.Direction.DESC,
                        paginationQuery.getSortBy())
        );

        Page<PostEntity> page = postRepositoryJPA.findAll(pageable);
        return postMapper.toPageModel(page);
    }
}
