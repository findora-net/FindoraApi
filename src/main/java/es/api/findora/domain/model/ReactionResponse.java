package es.api.findora.domain.model;

import lombok.Data;

@Data
public class ReactionResponse extends Reaction{
    private Response response;
}
