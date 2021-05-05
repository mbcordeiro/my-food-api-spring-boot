package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.Costumer;
import com.matheuscordeiro.myfoodapi.services.interfaces.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/costumers")
public class CostumerController {
    @Autowired
    CostumerService costumerService;

    @GetMapping
    public ResponseEntity<List<Costumer>> getCostumers() {
        return ResponseEntity.ok(costumerService.findCostumers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costumer> getCostumerById(@PathVariable Long id) {
        return ResponseEntity.ok(costumerService.findCostumerById(id).get());
    }

    @PostMapping
    public ResponseEntity<Costumer> saveCostumer(@RequestBody @Valid Costumer costumer) {
        costumer = costumerService.saveCostumer(costumer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(costumer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCostumer(@RequestBody @Valid Costumer costumer) throws ObjectNotFoundException {
        costumerService.updateCostumer(costumer);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> inactiveCostumer(@RequestBody @Valid Costumer costumer) throws ObjectNotFoundException {
        costumerService.inactivateCostumer(costumer.isActive(), costumer.getId());
        return ResponseEntity.noContent().build();
    }
}
