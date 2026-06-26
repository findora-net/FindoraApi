package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.Category;
import es.api.findora.domain.port.out.CategoryRepository;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public List<Category> getAll() {
        return List.of(new Category(1L,"Categoría Random"));
    }
}
