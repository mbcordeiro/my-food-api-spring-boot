package com.matheuscordeiro.myfoodapi.repositories;

import com.matheuscordeiro.myfoodapi.models.RestaurantAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantAddressRepository extends JpaRepository<RestaurantAddress, Long> {
}
