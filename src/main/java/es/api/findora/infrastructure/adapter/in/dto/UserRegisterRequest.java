package es.api.findora.infrastructure.adapter.in.dto;

import es.api.findora.domain.model.UserRole;
import es.api.findora.domain.model.UserStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserRegisterRequest {

    private String name;
    private String surname;
    private String username;
    private String image;
    private LocalDate birthdate;
    private String email;
    private String password;

    private int point;

    private LocalDateTime createdAt;
}
