package es.api.findora.application.usecase;

import es.api.findora.domain.port.in.LoginUseCase;
import es.api.findora.domain.port.auth.AuthenticationPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final AuthenticationPort authenticationPort;

    @Override
    public String execute(String username, String password) {
        return authenticationPort.login(username,password);
    }
}
