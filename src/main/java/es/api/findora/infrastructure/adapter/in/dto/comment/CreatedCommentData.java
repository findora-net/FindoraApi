package es.api.findora.infrastructure.adapter.in.dto.comment;

import lombok.Data;

@Data
public class CreatedCommentData {
    private Long id;
    private Long postId;
    private Long userId;
    private String username;
    private Integer rate;
    private String text;
    private String date;
}

