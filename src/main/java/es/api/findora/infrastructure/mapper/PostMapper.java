package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Post;
import es.api.findora.infrastructure.adapter.in.dto.CreatePostRequest;
import es.api.findora.infrastructure.adapter.in.dto.CreatePostResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    CreatePostResponse toCreatePostResponse(Post post);

    Post toDomain(CreatePostRequest createPostRequest);
}
