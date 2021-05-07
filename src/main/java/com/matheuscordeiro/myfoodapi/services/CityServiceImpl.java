package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.City;
import com.matheuscordeiro.myfoodapi.repositories.CityRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private static final String CITY = "City";

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(City city) throws ObjectNotFoundException {
        verifyIfExists(city.getId());
        return cityRepository.save(city);
    }

    @Override
    public void deleteCityById(Long id) throws ObjectNotFoundException {
        deleteCityById(id);
    }

    @Override
    public Pageable findPaginatedCity() {
        return null;
    }

    private City verifyIfExists(Long id) throws ObjectNotFoundException {
        return cityRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(CITY, id));
    }
}
