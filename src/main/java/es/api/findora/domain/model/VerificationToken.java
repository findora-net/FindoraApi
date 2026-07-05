package es.api.findora.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {

    private Long id;
    private LocalDateTime expiresAt;
    private String token;
    private Long userId;

}
