package es.api.findora.infrastructure.adapter.in.controller;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.in.ListPostUseCase;
import es.api.findora.domain.query.ListPostQuery;
import es.api.findora.domain.query.PaginationQuery;
import es.api.findora.infrastructure.adapter.in.dto.PageResponse;
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

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final ListPostUseCase listAllPostUseCase;
    private final PostMapper postMapper;

    @PostMapping("/request")
    public ResponseEntity<PageResponse<PostResponse>> list(@RequestBody ListPostRequest listPostRequest){

        PaginationQuery paginationQuery = listPostRequest.buildPaginationQuery();
        ListPostQuery listPostQuery = postMapper.toQuery(listPostRequest);

        PageModel<Post> page = listAllPostUseCase.execute(paginationQuery,listPostQuery);
        PageResponse<PostResponse> response = postMapper.toPageResponse(page);

        return ResponseEntity.ok(response);
    }
}
