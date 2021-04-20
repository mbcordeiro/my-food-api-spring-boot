package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.models.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findCategories();

    Optional<Category> findCategoryById(Long id);

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategoryById(Long id);

    public Pageable findPaginatedCategories();
}
