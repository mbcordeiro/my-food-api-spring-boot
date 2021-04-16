package com.matheuscordeiro.myfoodapi.repositories;

import com.matheuscordeiro.myfoodapi.models.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}
