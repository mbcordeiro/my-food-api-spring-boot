package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findCategories();

    Optional<Category> findCategoryById(Long id);

    Category saveCategory(Category category);

    Category updateCategory(Category category) throws ObjectNotFoundException;

    void deleteCategoryById(Long id) throws ObjectNotFoundException;

    public Pageable findPaginatedCategories();
}
