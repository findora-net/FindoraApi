package es.api.findora.infrastructure.adapter.in.dto.response;

import es.api.findora.infrastructure.adapter.in.dto.UserResponse;
import lombok.Data;

@Data
public class ResponseResponse {
    private Long id;
    private UserResponse user;
    private Integer rate;
    private String text;
    private String date;
}
