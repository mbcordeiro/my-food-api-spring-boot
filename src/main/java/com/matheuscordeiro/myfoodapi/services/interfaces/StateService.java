package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.State;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StateService {
    List<State> findSates();

    Optional<State> findStateById(Long id);

    State saveState(State state);

    State updateState(State state) throws ObjectNotFoundException;

    void deleteStateById(Long id) throws ObjectNotFoundException;

    public Pageable findPaginatedState();
}
