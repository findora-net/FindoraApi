package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReactionCommentId implements Serializable {

    private Long reactCommentUser;

    private Long reactedComment;

}
