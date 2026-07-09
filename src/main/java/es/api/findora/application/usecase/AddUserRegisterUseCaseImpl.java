package es.api.findora.application.usecase;

import es.api.findora.domain.exception.BusinessException;
import es.api.findora.domain.exception.ValidationException;
import es.api.findora.domain.model.RoleUser;
import es.api.findora.domain.model.StatusUser;
import es.api.findora.domain.model.User;
import es.api.findora.domain.model.VerificationToken;
import es.api.findora.domain.port.in.AddUserRegisterUseCase;
import es.api.findora.domain.port.in.VerificationTokenUseCase;
import es.api.findora.domain.port.out.EmailSender;
import es.api.findora.domain.port.out.PhotoRepository;
import es.api.findora.domain.port.out.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddUserRegisterUseCaseImpl implements AddUserRegisterUseCase {
    private final UserRepository userRepository;
    private final VerificationTokenUseCase verificationTokenUseCase;
    private final EmailSender emailSender;
    private final PhotoRepository photoStorage;

    @Override
    public User execute(User user, MultipartFile photo) {

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
        user.setStatus(StatusUser.DISACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        user.setRole(RoleUser.USER);
        User savedUser = userRepository.save(user);

        String photoUrl = uploadPhoto(photo);
        savedUser = userRepository.updatePhoto(photoUrl, savedUser);

        VerificationToken verificationToken = verificationTokenUseCase.createToken(savedUser.getId());
        //TODO Move link to properties - Iván
        String link = "http://localhost:8080/auth/verify?token=" + verificationToken.getToken();
        emailSender.sendVerificationEmail(savedUser.getEmail(), link);

        return savedUser;
    }

    public String uploadPhoto(MultipartFile photo){
        String photoUrl = null;

        if (photo != null && !photo.isEmpty()) {
            photoUrl = photoStorage.upload(photo);
        }
        return  photoUrl;
    }

}
