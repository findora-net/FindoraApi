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
    @ManyToOne
    @JoinColumn(name = "post_id")
    private User reactPostUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post reactedPost;

    @Column(name = "type")
    private TypeReactionComment type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
