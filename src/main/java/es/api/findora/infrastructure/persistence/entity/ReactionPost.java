package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "REACTION_POST")
@Data
@IdClass(ReactionPostId.class)
public class ReactionPost {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "type")
    private Type type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
