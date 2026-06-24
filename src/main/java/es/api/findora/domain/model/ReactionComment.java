package es.api.findora.domain.model;

import lombok.Data;

@Data
public class ReactionComment extends Reaction{
    private Comment comment;
}
