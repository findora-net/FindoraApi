package es.api.findora.infrastructure.adapter.in.dto.response;

import lombok.Data;

@Data
public class CreatedResponseData {
    private Long id;
    private Long commentId;
    private Long userId;
    private String username;
    private Integer rate;
    private String text;
    private String date;
}
