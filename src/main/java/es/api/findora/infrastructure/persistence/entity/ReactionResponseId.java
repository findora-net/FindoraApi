package es.api.findora.infrastructure.persistence.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReactionResponseId implements Serializable {
    private Long reactResponseUser;

    private Long reactResponse;
}
