package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Restaurant;
import com.matheuscordeiro.myfoodapi.services.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return ResponseEntity.ok(restaurantService.findRestaurants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable  Long id) {
        return ResponseEntity.ok(restaurantService.findRestaurantById(id).get());
    }

    @PostMapping
    public ResponseEntity<Restaurant> saveRestaurants(@RequestBody @Valid Restaurant restaurant) {
        restaurant = restaurantService.saveRestaurant(restaurant);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(restaurant.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void>  updateRestaurants(@RequestBody @Valid Restaurant restaurant) throws ObjectNotFoundException {
        restaurantService.updateRestaurant(restaurant);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateRestaurants(@PathVariable Long id) throws ObjectNotFoundException {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.noContent().build();
    }
}
