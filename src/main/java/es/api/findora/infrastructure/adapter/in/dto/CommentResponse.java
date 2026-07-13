package es.api.findora.infrastructure.adapter.in.dto;

import es.api.findora.domain.model.Post;
import es.api.findora.domain.model.User;
import lombok.Data;

import java.util.List;

@Data
public class CommentResponse {
    private Long id;
    private UserResponse user;
    private Integer rate;
    private String text;
    private String date;
    private List<ResponseResponse> responses;
}

