package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Costumer;

import java.util.List;
import java.util.Optional;

public interface CostumerService {
    List<Costumer> findCostumers();

    Optional<Costumer> findCostumerById(Long id);

    Costumer saveCostumer(Costumer costumer);

    Costumer updateCostumer(Costumer costumer) throws ObjectNotFoundException;

    boolean inactivateCostumer(boolean isActive, Long id) throws ObjectNotFoundException;
}
