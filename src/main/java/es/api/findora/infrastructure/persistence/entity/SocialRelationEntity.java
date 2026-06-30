package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "SOCIAL_RELATION")
@IdClass(SocialRelationId.class)
@Data
public class SocialRelationEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "origin_user_id")
    private UserEntity originUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private UserEntity targetUser;

    @Column(name="type")
    private Enum<TypeSocialRelation> type;

    @Column(name="created_at")
    private LocalDateTime createdAt;

}
