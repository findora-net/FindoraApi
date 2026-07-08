package es.api.findora.domain.command.post;

import lombok.Data;

@Data
public class CreatePostCommand {

    private Long idLocation;
    private String title;
    private String content;
    private Long idCategory;
    private Long idOwner;
}
