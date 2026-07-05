package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "REACTION_COMMENT")
@IdClass(ReactionCommentId.class)
public class ReactionCommentEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity reactCommentUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity reactedComment;

    @Column(name = "type")
    private Enum<TypeReactionComment> type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
