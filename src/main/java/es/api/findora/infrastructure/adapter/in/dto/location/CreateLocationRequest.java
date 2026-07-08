package es.api.findora.infrastructure.adapter.in.dto.location;

import es.api.findora.infrastructure.persistence.entity.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateLocationRequest {

    private String name;
    private Double latitud;
    private Double longitud;
    private Boolean isActive;
    private UserEntity creator;
    private LocalDateTime createdAt;

}
