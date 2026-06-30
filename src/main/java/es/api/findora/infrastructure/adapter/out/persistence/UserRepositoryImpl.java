package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.User;
import es.api.findora.domain.port.out.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository jpa;

    @Override
    public User save(User user) {
        return jpa.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpa.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpa.existsByUsername(username);
    }
}
