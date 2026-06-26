package es.api.findora.infrastructure.adapter.in.controller;

import es.api.findora.domain.model.Category;
import es.api.findora.domain.port.in.GetAllCategoriesUseCase;
import es.api.findora.infrastructure.adapter.in.dto.CategoryResponse;
import es.api.findora.infrastructure.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final CategoryMapper categoryMapper;

    public CategoryController(GetAllCategoriesUseCase getAllCategoriesUseCase, CategoryMapper categoryMapper) {
        this.getAllCategoriesUseCase = getAllCategoriesUseCase;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategory(){
        List<Category> categories = getAllCategoriesUseCase.execute();
        return ResponseEntity.ok(categories.stream().map(categoryMapper::toCategoryResponse).toList());
    }
}
