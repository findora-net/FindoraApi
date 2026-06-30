package es.api.findora.domain.port.in;

import es.api.findora.domain.model.User;

public interface AddUserRegisterUseCase {

    User execute(User user);
}
