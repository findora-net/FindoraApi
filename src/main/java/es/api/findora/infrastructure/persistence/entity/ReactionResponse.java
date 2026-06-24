package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "REACTION_RESPONSE")
public class ReactionResponse {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "response_id")
    private Long responseId;

    @Column(name = "type")
    private Enum<Type> type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
