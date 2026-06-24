package es.api.findora.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SocialRelation {
    private User originUser;
    private User targetUser;
    private SocialRelationType type;
    private LocalDateTime createdAt;
}
