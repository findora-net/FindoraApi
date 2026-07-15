package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.SortDirection;
import es.api.findora.domain.port.out.CommentRepository;
import es.api.findora.infrastructure.mapper.CommentPersistenceMapper;
import es.api.findora.infrastructure.persistence.entity.CommentEntity;
import es.api.findora.infrastructure.persistence.repository.CommentRepositoryJPA;
import es.api.findora.infrastructure.persistence.repository.PostRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final CommentRepositoryJPA JPARepo;
    private final CommentPersistenceMapper mapper;
    private final PostRepositoryJPA postRepositoryJPA;


    @Override
    public boolean existsPost(Long postId) {
        return postRepositoryJPA.existsById(postId);
    }

    @Override
    public List<Comment> getCommentsOrdered(Long postId, SortDirection direction) {

        List<CommentEntity> entities = direction == SortDirection.ASC ? JPARepo.findByCommentedPost_IdOrderByCreatedAtAsc(postId) : JPARepo.findByCommentedPost_IdOrderByCreatedAtDesc(postId);

        return entities.stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return JPARepo.findById(id).map(mapper::toDomain);
    }

    @Override
    public Comment save(Comment comment) {
        CommentEntity entity = mapper.toEntity(comment);
        CommentEntity savedEntity = JPARepo.save(entity);
        return mapper.toDomain(savedEntity);
    }
}
