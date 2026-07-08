package es.api.findora.infrastructure.persistence.repository;

import es.api.findora.infrastructure.persistence.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepositoryJPA extends JpaRepository<LocationEntity, Long> {
}
