package es.api.findora.infrastructure.adapter.in.dto;

import es.api.findora.infrastructure.persistence.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterResponse {

    private Long id;
    private String username;
    private String name;
    private String email;
    private UserRole role;

}
