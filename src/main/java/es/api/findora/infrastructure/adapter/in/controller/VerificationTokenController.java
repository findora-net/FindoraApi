package es.api.findora.infrastructure.adapter.in.controller;


import es.api.findora.domain.port.in.VerificationTokenUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class VerificationTokenController {

    private final VerificationTokenUseCase verificationTokenUseCase;


    @GetMapping("/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam("token") String token) {
        verificationTokenUseCase.verify(token);
        return ResponseEntity.ok("Cuenta verificada correctamente. Ya puedes iniciar sesión.");
    }
}
