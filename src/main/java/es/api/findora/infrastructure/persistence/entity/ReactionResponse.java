package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "REACTION_RESPONSE")
@IdClass(ReactionResponseId.class)
public class ReactionResponse {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reactResponseUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "response_id")
    private Response reactResponse;

    @Column(name = "type")
    private Enum<TypeReactionComment> type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
