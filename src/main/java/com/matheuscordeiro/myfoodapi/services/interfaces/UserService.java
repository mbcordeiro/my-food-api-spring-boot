package com.matheuscordeiro.myfoodapi.services.interfaces;

import com.matheuscordeiro.myfoodapi.exceptions.ObjectNotFoundException;
import com.matheuscordeiro.myfoodapi.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findUsers();

    Optional<User> findUserById(Long id);

    User saveUser(User user);

    User updateUser(User user) throws ObjectNotFoundException;

    boolean inactivateUser();
}
