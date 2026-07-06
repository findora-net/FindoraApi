package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Category;
import es.api.findora.infrastructure.adapter.in.dto.CategoryResponse;
import es.api.findora.infrastructure.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);

    Category toModel(CategoryEntity category);
}
