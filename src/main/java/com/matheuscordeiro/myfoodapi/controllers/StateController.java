package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.State;
import com.matheuscordeiro.myfoodapi.services.interfaces.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {
    @Autowired
    StateService stateService;

    @GetMapping
    public ResponseEntity<List<State>> getCountries() {
        return ResponseEntity.ok(stateService.findSates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getCountryById(Long id) {
        return ResponseEntity.ok(stateService.findStateById(id).get());
    }

    @PostMapping
    public ResponseEntity<State> saveState(@RequestBody @Valid State state) {
        return ResponseEntity.ok(stateService.saveState(state));
    }

    @PutMapping
    public ResponseEntity<Void> updateState(@RequestBody @Valid State state) throws ObjectNotFoundException {
        stateService.updateState(state);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteStateById(Long id) throws ObjectNotFoundException {
        stateService.deleteStateById(id);
    }
}
