package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.command.post.CreatePostCommand;
import es.api.findora.domain.exception.NotFoundException;
import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.PaginationRequest;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.out.PostRepository;
import es.api.findora.infrastructure.mapper.PostMapper;
import es.api.findora.infrastructure.persistence.entity.CategoryEntity;
import es.api.findora.infrastructure.persistence.entity.LocationEntity;
import es.api.findora.infrastructure.persistence.entity.PostEntity;
import es.api.findora.infrastructure.persistence.entity.UserEntity;
import es.api.findora.infrastructure.persistence.repository.CategoryRepositoryJPA;
import es.api.findora.infrastructure.persistence.repository.LocationRepositoryJPA;
import es.api.findora.infrastructure.persistence.repository.PostRepositoryJPA;
import es.api.findora.infrastructure.persistence.repository.UserRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostRepositoryJPA postRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;
    private final CategoryRepositoryJPA categoryRepositoryJPA;
    private final LocationRepositoryJPA locationRepositoryJPA;
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

    @Override
    public Post save(CreatePostCommand createPostCommand){

        PostEntity entity = postMapper.toEntity(createPostCommand);

        UserEntity owner = userRepositoryJPA.findById(createPostCommand.getIdOwner()).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
        LocationEntity location = locationRepositoryJPA.findById(createPostCommand.getIdLocation()).orElseThrow(() -> new NotFoundException("Localizacion no encontrada"));
        CategoryEntity category = categoryRepositoryJPA.findById(createPostCommand.getIdCategory()).orElseThrow(() -> new NotFoundException("Categoría no encontrada"));

        entity.setCategoryPost(category);
        entity.setLocationPost(location);
        entity.setPostOwner(owner);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setRate(0);
        entity.setIsActive(true);

        this.postRepositoryJPA.save(entity);
        return postMapper.toModel(entity);

    }
}
