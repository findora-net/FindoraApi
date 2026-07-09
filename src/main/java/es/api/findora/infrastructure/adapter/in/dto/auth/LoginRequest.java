package es.api.findora.infrastructure.adapter.in.dto.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
