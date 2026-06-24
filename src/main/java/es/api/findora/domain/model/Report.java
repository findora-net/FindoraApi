package es.api.findora.domain.model;

import java.time.LocalDateTime;

public class Report {
    private Long id;
    private String title;
    private String text;
    private Boolean isActive;
    private User createdBy;
    private LocalDateTime createdAt;
}
