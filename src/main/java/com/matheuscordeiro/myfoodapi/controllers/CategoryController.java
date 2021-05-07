package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.RestaurantCategory;
import com.matheuscordeiro.myfoodapi.services.interfaces.RestaurantCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/restaurant/categories")
public class CategoryController {
    @Autowired
    RestaurantCategoryService restaurantCategoryService;

    @GetMapping
    public ResponseEntity<List<RestaurantCategory>> getRestaurantCategories() {
        return ResponseEntity.ok(restaurantCategoryService.findRestaurantCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantCategory> getRestaurantCategoriesById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantCategoryService.findRestaurantCategoryById(id).get());
    }

    @PostMapping
    public ResponseEntity<RestaurantCategory> saveRestaurantCategory(@RequestBody @Valid RestaurantCategory restaurantCategory) {
        restaurantCategory = restaurantCategoryService.saveRestaurantCategory(restaurantCategory);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(restaurantCategory.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateRestaurantCategory(@RequestBody @Valid RestaurantCategory restaurantCategory) throws ObjectNotFoundException {
        restaurantCategoryService.updateRestaurantCategory(restaurantCategory);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurantCategoryById(@PathVariable Long id) throws ObjectNotFoundException {
        restaurantCategoryService.deleteRestaurantCategoryById(id);
    }
}
