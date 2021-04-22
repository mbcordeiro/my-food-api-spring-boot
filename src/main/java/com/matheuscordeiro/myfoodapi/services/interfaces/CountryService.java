package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findCountries();

    Optional<Country> findCountryById(Long id);

    Country saveCountry(Country country);

    Country updateCountry(Country country) throws ObjectNotFoundException;

    void deleteCountryById(Long id) throws ObjectNotFoundException;
}
