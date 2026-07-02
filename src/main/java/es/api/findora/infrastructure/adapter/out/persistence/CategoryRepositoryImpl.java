package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.Category;
import es.api.findora.domain.port.out.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public List<Category> getAll() {
        return List.of(new Category(1L,"Categoría Random"));
    }
}
