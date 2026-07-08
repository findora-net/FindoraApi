package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Location {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Boolean isActive;
    private User createdBy;
    private LocalDateTime createdAt;
}
