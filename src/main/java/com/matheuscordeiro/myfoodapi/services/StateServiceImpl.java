package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.State;
import com.matheuscordeiro.myfoodapi.repositories.StateRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateServiceImpl implements StateService {
    private static final String STATE = "State";

    @Autowired
    StateRepository stateRepository;

    @Override
    public List<State> findSates() {
        return stateRepository.findAll();
    }

    @Override
    public Optional<State> findStateById(Long id) {
        return stateRepository.findById(id);
    }

    @Override
    public State saveState(State state) {
        return stateRepository.save(state);
    }

    @Override
    public State updateState(State state) throws ObjectNotFoundException {
        verifyIfExists(state.getId());
        return stateRepository.save(state);
    }

    @Override
    public void deleteStateById(Long id) throws ObjectNotFoundException {
        verifyIfExists(id);
        stateRepository.deleteById(id);
    }

    @Override
    public Pageable findPaginatedState() {
        return null;
    }

    private State verifyIfExists(Long id) throws ObjectNotFoundException {
        return stateRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(STATE, id));
    }
}
