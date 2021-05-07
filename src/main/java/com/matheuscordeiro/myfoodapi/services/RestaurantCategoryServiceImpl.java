package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.RestaurantCategory;
import com.matheuscordeiro.myfoodapi.repositories.CategoryRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.RestaurantCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantCategoryServiceImpl implements RestaurantCategoryService {
    private static final String RESTAURANT_CATEGORY = "Restaurant Category";

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<RestaurantCategory> findRestaurantCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<RestaurantCategory> findRestaurantCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public RestaurantCategory saveRestaurantCategory(RestaurantCategory restaurantCategory) {
        return categoryRepository.save(restaurantCategory);
    }

    @Override
    public RestaurantCategory updateRestaurantCategory(RestaurantCategory restaurantCategory) throws ObjectNotFoundException {
        verifyIfExists(restaurantCategory.getId());
        return categoryRepository.save(restaurantCategory);
    }

    @Override
    public void deleteRestaurantCategoryById(Long id) throws ObjectNotFoundException {
        verifyIfExists(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public Pageable findPaginatedRestaurantCategories() {
        return null;
    }

    private RestaurantCategory verifyIfExists(Long id) throws ObjectNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(RESTAURANT_CATEGORY, id));
    }
}
