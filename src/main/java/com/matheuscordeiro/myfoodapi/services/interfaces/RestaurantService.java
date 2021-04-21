package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Restaurant;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<Restaurant> findRestaurants();

    Optional<Restaurant> findRestaurantById(Long id);

    Restaurant saveRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(Restaurant restaurant) throws ObjectNotFoundException;

    void deleteRestaurantById(Long id) throws ObjectNotFoundException;

    public Pageable findPaginatedCategories();
}
