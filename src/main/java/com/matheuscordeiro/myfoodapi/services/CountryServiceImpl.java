package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Country;
import com.matheuscordeiro.myfoodapi.models.Restaurant;
import com.matheuscordeiro.myfoodapi.repositories.CountryRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CountryServiceImpl implements CountryService {
    private static final String COUNTRY = "Country";

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> findCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) throws ObjectNotFoundException {
        verifyIfExists(country.getId());
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountryById(Long id) throws ObjectNotFoundException {
        verifyIfExists(id);
        countryRepository.deleteById(id);
    }

    private Country verifyIfExists(Long id) throws ObjectNotFoundException {
        return countryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(COUNTRY, id));
    }
}
