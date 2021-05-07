package com.matheuscordeiro.myfoodapi.repositories;

import com.matheuscordeiro.myfoodapi.models.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<RestaurantCategory, Long> {
}
