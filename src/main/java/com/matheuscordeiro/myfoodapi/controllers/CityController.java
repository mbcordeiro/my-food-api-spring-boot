package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.City;
import com.matheuscordeiro.myfoodapi.services.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getStates() {
        return ResponseEntity.ok(cityService.findCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(Long id) {
        return ResponseEntity.ok(cityService.findCityById(id).get());
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody @Valid City city) {
        return ResponseEntity.ok(cityService.saveCity(city));
    }

    @PutMapping
    public ResponseEntity<Void> updateCity(@RequestBody @Valid City city) throws ObjectNotFoundException {
        cityService.updateCity(city);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(Long id) throws ObjectNotFoundException {
        cityService.deleteCityById(id);
    }
}
