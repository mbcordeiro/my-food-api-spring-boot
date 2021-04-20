package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.models.Category;
import com.matheuscordeiro.myfoodapi.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.findCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoriesById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id).get());
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody @Valid Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @PutMapping
    public ResponseEntity<Void> updateCategory(@RequestBody @Valid Category category) {
        categoryService.updateCategory(category);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
