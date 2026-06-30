package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "VERIFICATION_TOKEN")
@Data
public class VerificationTokenEntity {

    @Id
    private Long id;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "token")
    private String token;

    @Column(name = "user_id")
    private Long userId;



}
