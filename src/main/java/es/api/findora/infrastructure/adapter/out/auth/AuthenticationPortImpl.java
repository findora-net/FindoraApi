package es.api.findora.infrastructure.adapter.out.auth;

import es.api.findora.domain.model.User;
import es.api.findora.domain.port.auth.AuthenticationPort;
import es.api.findora.infrastructure.jwt.JwtUtil;
import es.api.findora.infrastructure.security.UserDetailAdapter;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AuthenticationPortImpl implements AuthenticationPort {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(String username, String password) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        User user =  ((UserDetailAdapter) authentication.getPrincipal()).getUser();

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getEmail(),
                user.getRole().toString(),
                user.getCreatedAt()
        );

        return token;
    }
}
