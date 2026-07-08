package es.api.findora.domain.port.in;

import es.api.findora.domain.command.post.CreatePostCommand;
import es.api.findora.domain.model.Post;

public interface SavePostUseCase {

    public Post execute(CreatePostCommand createPostCommand);
}
