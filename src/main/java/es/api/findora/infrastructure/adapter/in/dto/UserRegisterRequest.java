package es.api.findora.infrastructure.adapter.in.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRegisterRequest {

    private String name;
    private String surname;
    private String username;
    private LocalDate birthdate;
    private String email;
    private String password;
}
