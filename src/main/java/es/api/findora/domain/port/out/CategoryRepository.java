package es.api.findora.domain.port.out;

import es.api.findora.domain.model.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> getAll();
}
