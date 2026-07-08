package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.command.post.CreatePostCommand;
import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.Post;
import es.api.findora.infrastructure.adapter.in.dto.PageResponse;
import es.api.findora.infrastructure.adapter.in.dto.post.PostResponse;
import es.api.findora.infrastructure.persistence.entity.PostEntity;
import es.api.findora.infrastructure.adapter.in.dto.post.CreatePostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = {
        PageMapper.class,
        UserMapper.class,
        LocationMapper.class,
        CategoryMapper.class
})
public abstract class PostMapper {

    @Autowired
    protected PageMapper pageMapper;

    @Mapping(source = "locationPost", target = "location")
    @Mapping(source = "categoryPost", target = "category")
    @Mapping(source = "postOwner", target = "createdBy")
    public abstract Post toModel(PostEntity postEntity);

    public abstract PostResponse toPostResponse(Post post);

    public abstract Post toDomain(CreatePostRequest createPostRequest);

    public abstract PostEntity toEntity(Post post);

    public abstract PostEntity toEntity(CreatePostCommand createPostCommand);

    public abstract CreatePostCommand toCreatePostCommand(CreatePostRequest createPostRequest);

    public PageResponse<PostResponse> toPageResponse(PageModel<Post> page) {
        return pageMapper.toPageResponse(page, this::toPostResponse);
    }

    public PageModel<Post> toPageModel(Page<PostEntity> page){
        return pageMapper.toPageModel(page, this::toModel);
    }
}
