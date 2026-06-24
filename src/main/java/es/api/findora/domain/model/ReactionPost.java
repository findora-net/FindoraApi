package es.api.findora.domain.model;

import lombok.Data;

@Data
public class ReactionPost extends Reaction{
    private Post post;
}
