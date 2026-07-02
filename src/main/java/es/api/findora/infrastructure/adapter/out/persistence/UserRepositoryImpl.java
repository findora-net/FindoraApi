package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.User;
import es.api.findora.domain.port.out.UserRepository;
import es.api.findora.infrastructure.mapper.UserMapper;
import es.api.findora.infrastructure.persistence.entity.UserEntity;
import es.api.findora.infrastructure.persistence.repository.UserRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;


    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userRepositoryJPA.save(userEntity);
        return userMapper.toModel(userEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpa.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpa.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        List<UserEntity> users = userRepositoryJPA.findByUsername(username);

        if(users.isEmpty()){
            return null;
        }

        return userMapper.toModel(users.getFirst());
    }

    @Override
    public User findByEmail(String email) {
        List<UserEntity> users = userRepositoryJPA.findByEmail(email);

        if(users.isEmpty()){
            return null;
        }

        return userMapper.toModel(users.getFirst());
    }
}
