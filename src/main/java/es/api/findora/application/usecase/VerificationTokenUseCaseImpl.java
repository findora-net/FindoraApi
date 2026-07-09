package es.api.findora.application.usecase;

import es.api.findora.domain.exception.BusinessException;
import es.api.findora.domain.exception.NotFoundException;
import es.api.findora.domain.model.StatusUser;
import es.api.findora.domain.model.User;
import es.api.findora.domain.model.VerificationToken;
import es.api.findora.domain.port.in.VerificationTokenUseCase;
import es.api.findora.domain.port.out.UserRepository;
import es.api.findora.domain.port.out.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VerificationTokenUseCaseImpl implements VerificationTokenUseCase {
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;


    @Override
    public VerificationToken findByToken(String token) {
        VerificationToken vt = verificationTokenRepository.findByToken(token);
        if (vt == null) {
            throw new BusinessException("Token inválido");
        }
        return vt;
    }

    @Override
    public void verify(String token) {
        VerificationToken vt = verificationTokenRepository.findByToken(token);

        if (vt == null) {
            throw new BusinessException("Token inválido");
        }

        if (vt.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Token expirado");
        }

        User user = userRepository.findById(vt.getUserId());

        if (user == null) {
            throw new NotFoundException("Usuario no encontrado");
        }

        user.setStatus(StatusUser.ACTIVE);
        userRepository.save(user);

        verificationTokenRepository.delete(vt);
    }

    @Override
    public VerificationToken createToken(Long userId) {
        return verificationTokenRepository.createToken(userId);
    }


}
