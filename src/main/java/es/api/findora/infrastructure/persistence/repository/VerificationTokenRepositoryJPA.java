package es.api.findora.infrastructure.persistence.repository;

import es.api.findora.domain.model.VerificationToken;
import es.api.findora.infrastructure.persistence.entity.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepositoryJPA extends JpaRepository<VerificationTokenEntity, Long> {
    void delete(VerificationToken vt);

    VerificationTokenEntity findByToken(String token);
}
