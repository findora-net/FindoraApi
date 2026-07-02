package es.api.findora.application.usecase;

import es.api.findora.domain.exception.BusinessException;
import es.api.findora.domain.exception.ValidationException;
import es.api.findora.domain.model.User;
import es.api.findora.domain.port.in.AddUserRegisterUseCase;
import es.api.findora.domain.port.out.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddUserRegisterUseCaseImpl implements AddUserRegisterUseCase {

    private final UserRepository userRepository;

    @Override
    public User execute(User user) {

        // Validación de email duplicado
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BusinessException("El email ya está registrado");
        }

        // Validación de username duplicado
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new BusinessException("El username ya está registrado");
        }

        // Validación de contraseña
        if (user.getPassword().length() < 6) {
            throw new ValidationException("La contraseña debe tener mínimo 6 caracteres");
        }

        return userRepository.save(user);
    }
}
