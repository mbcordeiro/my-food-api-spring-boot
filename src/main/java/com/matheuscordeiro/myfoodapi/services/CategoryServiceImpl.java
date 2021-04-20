package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.models.Category;
import com.matheuscordeiro.myfoodapi.repositories.CategoryRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        verifyIfExists(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        verifyIfExists(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public Pageable findPaginatedCategories() {
        return null;
    }

    private Category verifyIfExists(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
