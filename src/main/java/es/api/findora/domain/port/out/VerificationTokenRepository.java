package es.api.findora.domain.port.out;

import es.api.findora.domain.model.VerificationToken;

public interface VerificationTokenRepository {

    VerificationToken findByToken(String token);
    VerificationToken createToken(Long userId);

    void delete(VerificationToken vt);
}
