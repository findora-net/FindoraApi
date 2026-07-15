package es.api.findora.infrastructure.persistence.repository;

import es.api.findora.domain.model.Response;
import es.api.findora.domain.port.out.ResponseRepository;
import es.api.findora.infrastructure.persistence.entity.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepositoryJPA extends JpaRepository<ResponseEntity, Long> {

}
