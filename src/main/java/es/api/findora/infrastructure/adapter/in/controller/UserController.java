package es.api.findora.infrastructure.adapter.in.controller;

import es.api.findora.domain.model.User;
import es.api.findora.domain.port.in.AddUserRegisterUseCase;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterRequest;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UserController {

    private final AddUserRegisterUseCase addUserRegisterUseCase;

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@Valid @RequestBody UserRegisterRequest userRegisterRequest, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            throw new Exception();
        }
        User userValid = new User(
                null,
                userRegisterRequest.getName(),
                userRegisterRequest.getSurname(),
                userRegisterRequest.getUsername(),
                userRegisterRequest.getImage(),
                userRegisterRequest.getBirthdate(),
                userRegisterRequest.getEmail(),
                userRegisterRequest.getPassword(),
                null,
                0,
                null,
                LocalDateTime.now()
        );
        User saved = addUserRegisterUseCase.execute(userValid);

        UserRegisterResponse response = new UserRegisterResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole()
        );

        return ResponseEntity.ok(response);

    }
}
