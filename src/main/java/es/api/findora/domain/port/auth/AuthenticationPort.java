package es.api.findora.domain.port.auth;

public interface AuthenticationPort {

    String login(String username, String password);
}
