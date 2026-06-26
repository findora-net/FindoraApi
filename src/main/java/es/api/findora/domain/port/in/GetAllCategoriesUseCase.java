package es.api.findora.domain.port.in;

import es.api.findora.domain.model.Category;

import java.util.List;

public interface GetAllCategoriesUseCase {

    List<Category> execute();
}
