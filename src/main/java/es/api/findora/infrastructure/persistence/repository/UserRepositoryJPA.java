package es.api.findora.infrastructure.persistence.repository;

import es.api.findora.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {



}
