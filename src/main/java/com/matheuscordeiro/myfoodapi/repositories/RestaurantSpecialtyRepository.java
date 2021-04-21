package com.matheuscordeiro.myfoodapi.repositories;

import com.matheuscordeiro.myfoodapi.models.RestaurantSpecialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantSpecialtyRepository extends JpaRepository<RestaurantSpecialty, Long> {
}
