package es.api.findora.infrastructure.adapter.in.controller;

import es.api.findora.domain.model.Comment;
import es.api.findora.domain.model.SortDirection;
import es.api.findora.domain.port.in.GetCommentsByDateUseCase;
import es.api.findora.infrastructure.adapter.in.dto.comment.CommentResponse;
import es.api.findora.infrastructure.mapper.CommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {

    private final GetCommentsByDateUseCase getCommentsByDateUseCase;
    private final CommentMapper commentMapper;

    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentResponse>> getCommentsSorted(
            @PathVariable Long postId,
            @RequestParam(required = false) String direction) {

        SortDirection sortDirection = (direction == null)
                ? SortDirection.DESC
                : SortDirection.valueOf(direction.toUpperCase());

        List<Comment> comments = getCommentsByDateUseCase.execute(postId, sortDirection);

        return ResponseEntity.ok(
                comments.stream()
                        .map(commentMapper::toCommentResponse)
                        .toList()
        );
    }
}
