package es.api.findora.infrastructure.persistence.repository;

import es.api.findora.infrastructure.persistence.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepositoryJPA extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByCommentedPost_IdOrderByCreatedAtAsc(Long postId);

    List<CommentEntity> findByCommentedPost_IdOrderByCreatedAtDesc(Long postId);
}

