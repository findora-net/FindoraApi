package es.api.findora.domain.port.in;

import es.api.findora.domain.model.User;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterRequest;

public interface AddUserRegisterUseCase {
    User execute(UserRegisterRequest request);
}

