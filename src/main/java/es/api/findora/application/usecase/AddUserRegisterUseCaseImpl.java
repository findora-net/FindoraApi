package es.api.findora.application.usecase;

import es.api.findora.domain.model.User;
import es.api.findora.domain.port.in.AddUserRegisterUseCase;
import es.api.findora.domain.port.out.UserRepository;

import es.api.findora.infrastructure.adapter.in.dto.UserRegisterRequest;
import es.api.findora.infrastructure.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddUserRegisterUseCaseImpl implements AddUserRegisterUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User execute(UserRegisterRequest request) {

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

        User user = userMapper.toEntity(request);
        String hashed = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashed);

        return userRepository.save(user);
    }
}
