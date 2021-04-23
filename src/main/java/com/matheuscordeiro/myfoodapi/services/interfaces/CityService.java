package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.City;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> findCities();

    Optional<City> findCityById(Long id);

    City saveCity(City city);

    City updateCity(City city) throws ObjectNotFoundException;

    void deleteCityById(Long id) throws ObjectNotFoundException;

    public Pageable findPaginatedCity();
}
