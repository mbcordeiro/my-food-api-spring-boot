package com.matheuscordeiro.myfoodapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends Exception{
    public ObjectNotFoundException(String objectName, String name) {
        super(String.format("%s with name %s not found in the system.", objectName, name));
    }

    public ObjectNotFoundException(String objectName, Long id) {
        super(String.format("%s with id %s not found in the system.", objectName, id));
    }
}
