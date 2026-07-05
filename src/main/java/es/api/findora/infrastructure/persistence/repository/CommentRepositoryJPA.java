package es.api.findora.infrastructure.persistence.repository;

import es.api.findora.infrastructure.persistence.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepositoryJPA extends JpaRepository<CommentEntity, Long> {
    boolean existsByPostId(Long postId);

    List<CommentEntity> findByPostIdOrderByCreatedAtAsc(Long postId);

    List<CommentEntity> findByPostIdOrderByCreatedAtDesc(Long postId);
}
