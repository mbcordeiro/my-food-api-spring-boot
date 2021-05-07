package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.RestaurantCategory;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RestaurantCategoryService {
    List<RestaurantCategory> findRestaurantCategories();

    Optional<RestaurantCategory> findRestaurantCategoryById(Long id);

    RestaurantCategory saveRestaurantCategory(RestaurantCategory restaurantCategory);

    RestaurantCategory updateRestaurantCategory(RestaurantCategory restaurantCategory) throws ObjectNotFoundException;

    void deleteRestaurantCategoryById(Long id) throws ObjectNotFoundException;

    public Page findPaginatedRestaurantCategories(Integer page, Integer linesPerPage, String orderBy, String direction);
}
