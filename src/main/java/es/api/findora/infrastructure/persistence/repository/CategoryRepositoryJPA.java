package es.api.findora.infrastructure.persistence.repository;

import es.api.findora.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryJPA extends JpaRepository<CategoryEntity, Long> {
}
