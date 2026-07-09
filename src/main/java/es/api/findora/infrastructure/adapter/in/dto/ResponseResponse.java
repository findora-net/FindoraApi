package es.api.findora.infrastructure.adapter.in.dto;

import lombok.Data;

@Data
public class ResponseResponse {
    private Long id;
    private UserResponse user;
    private Integer rate;
    private String text;
    private String date;
}
