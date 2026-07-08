package es.api.findora.application.usecase;

import es.api.findora.domain.command.post.CreatePostCommand;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.in.SavePostUseCase;
import es.api.findora.domain.port.out.PostRepository;
import es.api.findora.infrastructure.persistence.repository.PostRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SavePostUseCaseImpl implements SavePostUseCase {

    private final PostRepository postRepository;

    @Override
    public Post execute(CreatePostCommand createPostCommand) {

        return postRepository.save(createPostCommand);
    }
}
