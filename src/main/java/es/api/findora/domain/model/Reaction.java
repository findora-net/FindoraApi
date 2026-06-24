package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reaction {
    private User user;
    private ReactionType type;
    private LocalDateTime createdAt;
}
