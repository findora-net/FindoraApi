package es.api.findora.application.usecase;

import es.api.findora.domain.model.Category;
import es.api.findora.domain.port.in.GetAllCategoriesUseCase;
import es.api.findora.domain.port.out.CategoryRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> execute() {
        return this.categoryRepository.getAll();
    }
}
