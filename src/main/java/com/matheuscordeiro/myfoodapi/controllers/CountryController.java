package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Country;
import com.matheuscordeiro.myfoodapi.services.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(countryService.findCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(Long id) {
        return ResponseEntity.ok(countryService.findCountryById(id).get());
    }

    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody @Valid Country country) {
        return ResponseEntity.ok(countryService.saveCountry(country));
    }

    @PutMapping
    public ResponseEntity<Void> updateCountry(@RequestBody @Valid Country country) throws ObjectNotFoundException {
        countryService.updateCountry(country);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteCountryById(Long id) throws ObjectNotFoundException {
        countryService.deleteCountryById(id);
    }
}
