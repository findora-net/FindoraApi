package es.api.findora.domain.port.out;


import es.api.findora.domain.model.User;


public interface UserRepository {
    User save(User user);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    User findByUsername(String username);
    User findByEmail(String email);
    User updatePhoto(String photoUrl, User user);
    User findById(Long userId);
}
