package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.VerificationToken;
import es.api.findora.domain.port.out.VerificationTokenRepository;
import es.api.findora.infrastructure.mapper.VerificationTokenMapper;
import es.api.findora.infrastructure.persistence.entity.VerificationTokenEntity;
import es.api.findora.infrastructure.persistence.repository.VerificationTokenRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {

    private VerificationTokenRepositoryJPA verificationTokenRepositoryJPA;
    private VerificationTokenMapper verificationTokenMapper;

    @Override
    public VerificationToken findByToken(String token) {
        VerificationTokenEntity entity = verificationTokenRepositoryJPA.findByToken(token);
        return entity == null ? null : verificationTokenMapper.toModel(entity);
    }

    @Override
    public VerificationToken createToken(Long userId) {
        VerificationToken token = new VerificationToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUserId(userId);
        token.setExpiresAt(LocalDateTime.now().plusHours(24));

        VerificationTokenEntity verificationTokenEntity = verificationTokenMapper.toEntity(token);
        VerificationTokenEntity saved = verificationTokenRepositoryJPA.save(verificationTokenEntity);
        return verificationTokenMapper.toModel(saved);

    }

    @Override
    public void delete(VerificationToken vt) {
        VerificationTokenEntity entity = verificationTokenMapper.toEntity(vt);
        verificationTokenRepositoryJPA.delete(entity);
    }
}
