package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "VERIFICATION_TOKEN")
@Data
public class VerificationTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "token")
    private String token;

    @Column(name = "user_id")
    private Long userId;



}
