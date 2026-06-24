package es.api.findora.infrastructure.persistence.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReactionPostId implements Serializable {

    private Long userId;
    private Long postId;

}
