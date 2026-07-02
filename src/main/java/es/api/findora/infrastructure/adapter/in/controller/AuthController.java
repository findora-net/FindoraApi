package es.api.findora.infrastructure.adapter.in.controller;

import com.cloudinary.api.exceptions.BadRequest;
import es.api.findora.domain.port.in.LoginUseCase;
import es.api.findora.infrastructure.adapter.in.dto.LoginRequest;
import es.api.findora.infrastructure.adapter.in.dto.LoginResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@AllArgsConstructor
public class AuthController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(er -> sb.append("-" + er.getDefaultMessage()));
            throw new BadRequest(sb.toString());
        }

        String token = loginUseCase.execute(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
