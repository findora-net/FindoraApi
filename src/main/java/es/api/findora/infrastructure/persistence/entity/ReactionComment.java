package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "REACTION_COMMENT")
@IdClass(ReactionCommentId.class)
public class ReactionComment{

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "type")
    private Enum<Type> type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
