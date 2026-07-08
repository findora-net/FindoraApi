package es.api.findora.infrastructure.adapter.in.dto.user;

import lombok.Data;

@Data
public class UserResume {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String image;
}
