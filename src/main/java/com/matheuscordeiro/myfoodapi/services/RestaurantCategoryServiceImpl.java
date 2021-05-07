package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.RestaurantCategory;
import com.matheuscordeiro.myfoodapi.repositories.RestaurantCategoryRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.RestaurantCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantCategoryServiceImpl implements RestaurantCategoryService {
    private static final String RESTAURANT_CATEGORY = "Restaurant Category";

    @Autowired
    RestaurantCategoryRepository restaurantCategoryRepository;

    @Override
    public List<RestaurantCategory> findRestaurantCategories() {
        return restaurantCategoryRepository.findAll();
    }

    @Override
    public Optional<RestaurantCategory> findRestaurantCategoryById(Long id) {
        return restaurantCategoryRepository.findById(id);
    }

    @Override
    public RestaurantCategory saveRestaurantCategory(RestaurantCategory restaurantCategory) {
        return restaurantCategoryRepository.save(restaurantCategory);
    }

    @Override
    public RestaurantCategory updateRestaurantCategory(RestaurantCategory restaurantCategory) throws ObjectNotFoundException {
        verifyIfExists(restaurantCategory.getId());
        return restaurantCategoryRepository.save(restaurantCategory);
    }

    @Override
    public void deleteRestaurantCategoryById(Long id) throws ObjectNotFoundException {
        verifyIfExists(id);
        restaurantCategoryRepository.deleteById(id);
    }

    @Override
    public Page<RestaurantCategory> findPaginatedRestaurantCategories(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Pageable restaurantCategoryPageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return restaurantCategoryRepository.findAll(restaurantCategoryPageable);
    }

    private RestaurantCategory verifyIfExists(Long id) throws ObjectNotFoundException {
        return restaurantCategoryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(RESTAURANT_CATEGORY, id));
    }
}
