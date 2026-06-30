package es.api.findora.domain.port.out;

import es.api.findora.domain.model.User;

public interface UserRepository {

    User findByUsername(String username);
    User findByEmail(String email);
}
