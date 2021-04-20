package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.models.Costumer;
import com.matheuscordeiro.myfoodapi.repositories.CostumerRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerServiceImpl implements CostumerService {
    @Autowired
    CostumerRepository costumerRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Costumer> findCostumers() {
        return costumerRepository.findAll();
    }

    @Override
    public Optional<Costumer> findCostumerById(Long id) {
        return costumerRepository.findById(id);
    }

    @Transactional
    @Override
    public Costumer saveCostumer(Costumer costumer) {
        return saveCostumer(costumer);
    }

    @Transactional
    @Override
    public Costumer updateCostumer(Costumer costumer) {
        verifyIfExists(costumer.getId());
        return costumerRepository.save(costumer);
    }

    @Override
    public boolean inactivateCostumer(boolean isActive, Long id) {
        Costumer costumer = verifyIfExists(id);
        costumer.setActive(isActive);
        updateCostumer(costumer);
        return costumer.isActive();
    }

    private Costumer verifyIfExists(Long id) {
        return costumerRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
