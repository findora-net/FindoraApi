package es.api.findora.domain.port.in;

public interface LoginUseCase {

    String execute(String username, String password);
}
