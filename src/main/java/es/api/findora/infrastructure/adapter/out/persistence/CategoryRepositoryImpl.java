package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.Category;
import es.api.findora.domain.port.out.CategoryRepository;
import es.api.findora.infrastructure.mapper.CategoryMapper;
import es.api.findora.infrastructure.persistence.entity.CategoryEntity;
import es.api.findora.infrastructure.persistence.repository.CategoryRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryRepositoryJPA categoryRepositoryJPA;
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        List<CategoryEntity> categories = categoryRepositoryJPA.findAll();
        return categories.stream().map(categoryMapper::toModel).toList();
    }
}
