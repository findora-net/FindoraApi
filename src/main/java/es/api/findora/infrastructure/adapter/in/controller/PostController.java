package es.api.findora.infrastructure.adapter.in.controller;

import es.api.findora.domain.command.post.CreatePostCommand;
import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.in.ListPostUseCase;
import es.api.findora.domain.port.in.SavePostUseCase;
import es.api.findora.infrastructure.adapter.in.dto.PageResponse;
import es.api.findora.infrastructure.adapter.in.dto.post.CreatePostRequest;
import es.api.findora.infrastructure.adapter.in.dto.post.ListPostRequest;
import es.api.findora.infrastructure.adapter.in.dto.post.PostResponse;
import es.api.findora.infrastructure.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final ListPostUseCase listAllPostUseCase;
    private final SavePostUseCase savePostUseCase;
    private final PostMapper postMapper;

    @PostMapping("/request")
    public ResponseEntity<PageResponse<PostResponse>> list(@RequestBody ListPostRequest listPostRequest){

        PageModel<Post> page = listAllPostUseCase.execute(listPostRequest.getPageKey(), listPostRequest.getPageSize());
        PageResponse<PostResponse> response = postMapper.toPageResponse(page);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<PostResponse> save(@RequestBody CreatePostRequest createPostRequest){

        CreatePostCommand post = postMapper.toCreatePostCommand(createPostRequest);
        Post savedPost = savePostUseCase.execute(post);
        PostResponse response = postMapper.toPostResponse(savedPost);

        return ResponseEntity.created(URI.create("/" + response.getId())).body(response);
    }
}
