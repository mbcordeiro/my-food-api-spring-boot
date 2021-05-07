package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Restaurant;
import com.matheuscordeiro.myfoodapi.repositories.RestaurantRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private static final String RESTAURANT = "Restaurant";

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws ObjectNotFoundException {
        verifyIfExists(restaurant.getId());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurantById(Long id) throws ObjectNotFoundException {
        verifyIfExists(id);
        restaurantRepository.deleteById(id);
    }

    @Override
    public Page findPaginatedRestaurants(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Pageable restaurantPageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return restaurantRepository.findAll(restaurantPageable);
    }

    private Restaurant verifyIfExists(Long id) throws ObjectNotFoundException {
        return restaurantRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(RESTAURANT, id));
    }
}
