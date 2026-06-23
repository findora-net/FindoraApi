package es.api.findora.domain.model;

import java.time.LocalDateTime;

public class Location {
    private Long id;
    private String name;
    private Double latitud;
    private Double longitud;
    private Boolean isActive;
    private User createdBy;
    private LocalDateTime createdAt;
}
