package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "REACTION_RESPONSE")
@IdClass(ReactionResponseId.class)
public class ReactionResponseEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity reactResponseUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "response_id")
    private ResponseEntity reactResponse;

    @Column(name = "type")
    private Enum<TypeReactionComment> type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
