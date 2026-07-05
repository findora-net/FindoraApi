package es.api.findora.infrastructure.adapter.in.controller;

import es.api.findora.domain.model.User;
import es.api.findora.domain.port.in.AddUserRegisterUseCase;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterRequest;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterResponse;
import es.api.findora.infrastructure.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final AddUserRegisterUseCase addUserRegisterUseCase;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> userRegister(@Valid @RequestBody UserRegisterRequest userRegisterRequest, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            throw new Exception();
        }

        User user = userMapper.toModel(userRegisterRequest);

        User saved = addUserRegisterUseCase.execute(user);

        UserRegisterResponse response = userMapper.toResponse(saved);

        return ResponseEntity.ok(response);

    }
}
