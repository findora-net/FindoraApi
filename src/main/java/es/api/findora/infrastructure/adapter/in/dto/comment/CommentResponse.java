package es.api.findora.infrastructure.adapter.in.dto.comment;

import es.api.findora.infrastructure.adapter.in.dto.response.ResponseResponse;
import es.api.findora.infrastructure.adapter.in.dto.UserResponse;
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

