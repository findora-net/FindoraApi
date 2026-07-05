package es.api.findora.domain.port.in;

import es.api.findora.domain.model.VerificationToken;

public interface VerificationTokenUseCase {

    VerificationToken findByToken(String token);
    void verify(String token);
    VerificationToken createToken(Long userId);
}
